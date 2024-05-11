package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmdp.dto.Result;
import com.hmdp.dto.ScrollResult;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.Blog;
import com.hmdp.entity.Follow;
import com.hmdp.entity.User;
import com.hmdp.mapper.BlogMapper;
import com.hmdp.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.service.IFollowService;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 服务实现类
 *
 * @author ryanw
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Resource
    private IUserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private IFollowService followService;

    /**
     * 根据id查询Blog
     *
     * @param id Blog的id
     * @return Blog信息
     */
    @Override
    public Result queryBlogById(Long id) {
        // 1. 查询blog
        Blog blog = getById(id);
        if (blog == null) {
            return Result.fail("笔记不存在!");
        }

        // 2. 查询blog有关的用户，因为blog的信息中包含了用户名称、头像等等信息
        queryBlogUser(blog);

        // 3. 查询blog是否被点赞
        isBlockLiked(blog);

        return Result.ok(blog);
    }

    /**
     * @param current 当前Blog的分页
     * @return 根据火爆程度排序Blog
     */
    @Override
    public Result queryHotBlog(Integer current) {
        // 根据用户查询
        Page<Blog> page = query()
                .orderByDesc("liked")
                .page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
        // 获取当前页数据
        List<Blog> records = page.getRecords();
        // 查询用户
        records.forEach(blog -> {
            queryBlogUser(blog);
            isBlockLiked(blog);
        });
        return Result.ok(records);
    }

    /**
     * 判断blog是否被点赞过
     */
    private void isBlockLiked(Blog blog) {
        // 1. 获取登录用户
        UserDTO user = UserHolder.getUser();
        if (user == null) {
            // 用户未登录，无需查询是否点过赞
            return;
        }

        Long userId = user.getId();

        // 2. 判断当前登录用户是否已经点赞
        String key = "blog:liked:" + blog.getId();
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());

        blog.setIsLike(score != null);
    }

    /**
     * 查询于blog相关的用户信息
     * 由于根据id查询blog信息以及查询火爆blog信息两个方法都重复使用下面的代码逻辑，所以抽取
     * 成一个方法即可
     */
    private void queryBlogUser(Blog blog) {
        Long userId = blog.getUserId();
        User user = userService.getById(userId);
        blog.setName(user.getNickName());
        blog.setIcon(user.getIcon());
    }

    /**
     * Blog点赞功能
     *
     * @param id 当前已经点赞的Blog的id
     * @return 点赞成功与否结果
     */
    @Override
    public Result likeBlog(Long id) {
        // 1. 获取登录用户
        Long userId = UserHolder.getUser().getId();

        // 2. 判断当前登录用户是否已经点赞
        String key = RedisConstants.BLOG_LIKED_KEY + id;
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        // 3. 如果未点赞，可以点赞
        if (score == null) {
            // 3.1 数据库点赞数 + 1
            boolean isSuccess = update().setSql("liked = liked + 1").eq("id", id).update();

            // 3，2 保存用户到redis的set集合
            if (isSuccess) {
                // zadd key value score
                stringRedisTemplate.opsForZSet().add(key, userId.toString(), System.currentTimeMillis());
            }

        } else {
            // 4. 如果已点赞，取消点赞
            // 4.1 数据库点赞数 - 1
            boolean isSuccess = update().setSql("liked = liked - 1").eq("id", id).update();

            // 4.2 把用户从redis set集合里移除
            stringRedisTemplate.opsForZSet().remove(key, userId.toString());
        }


        return Result.ok();
    }

    /**
     * top5点赞排行榜功能
     *
     * @param id Blog的id
     * @return Blog的内容
     */
    @Override
    public Result queryBlogLikes(Long id) {
        // 1. 查询top 5的点赞用户 zrange key 0 4
        String key = RedisConstants.BLOG_LIKED_KEY + id;
        Set<String> top5 = stringRedisTemplate.opsForZSet().range(key, 0, 4);
        if (top5 == null || top5.isEmpty()) {
            return Result.ok(Collections.emptyList());
        }

        // 2. 解析出结果中的用户id
        List<Long> ids = top5.stream().map(Long::valueOf).collect(Collectors.toList());
        String idStr = StrUtil.join(", ", ids);

        // 3. 根据用户id查询用户 WHERE id IN (5, 1) ORDER BY FIELD (5, 1)
        Stream<UserDTO> userDTOs = userService.query()
                .in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list()
                .stream().map(
                        user -> BeanUtil.copyProperties(user, UserDTO.class)
                );

        // 4. 返回
        return Result.ok(userDTOs);
    }

    /**
     * 新增探店笔记，保存blog到数据库的同时，推送到粉丝的收件箱
     * @param blog blog对象
     * @return Result规范返回结果
     */
    @Override
    public Result saveBlog(Blog blog) {
        // 1. 获取登录用户
        UserDTO user = UserHolder.getUser();
        blog.setUserId(user.getId());

        // 2. 保存探店笔记
        boolean isSuccess = save(blog);
        if (!isSuccess) {
            return Result.fail("新增笔记失败！");
        }

        // 3. 查询笔记作者的所有粉丝 select * from tb_follow where follow_user_id = ?;
        List<Follow> follows = followService.query().eq("follow_user_id", user.getId()).list();

        // 4. 推送笔记id给所有粉丝
        for (Follow follow : follows) {
            // 4.1 获取粉丝id
            Long userId = follow.getUserId();
            // 4.2 推送
            String key = RedisConstants.FEED_KEY + userId;
            // 按照时间戳排序
            stringRedisTemplate.opsForZSet().add(key, blog.getId().toString(), System.currentTimeMillis());
        }

        // 5. 返回id
        return Result.ok(blog.getId());
    }

    /**
     * 查询滚动分页
     * @param max 最大时间戳
     * @param offset 偏移量
     * @return Result规范输出结果形式
     */
    @Override
    public Result queryBlogOfFollow(Long max, Integer offset) {
        // 1. 获取当前用户
        Long userId = UserHolder.getUser().getId();

        // 2. 通过key逆序查询收件箱 ZREVRANGEBYSCORE key Max Min LIMIT offset count
        String key =  RedisConstants.FEED_KEY + userId;
        Set<ZSetOperations.TypedTuple<String>> typedTuples = stringRedisTemplate.opsForZSet()
                .reverseRangeByScoreWithScores(key, 0, max, offset, 2);

        // 3. 非空判断
        if (typedTuples == null || typedTuples.isEmpty()) {
            // 如果查询结果为空，则直接返回一个空的结果
            return Result.ok() ;
        }

        // 4. 解析数据：blogId，minTime (时间戳), offset
        // 存储解析出的博客ID
        List<Long> ids = new ArrayList<>(typedTuples.size());
        // 记录遍历过程中的最小时间戳，用于下一次查询的max参数
        long minTime = 0;
        // os就是offset，计算新的offset，如果时间戳相同，offset增加，否则重置
        int os = 1;
        // 根据解析出的ID从数据库查询具体的博客详情，并对每个博客进行用户和点赞状态的查询处理
        for (ZSetOperations.TypedTuple<String> tuple : typedTuples) {
            // 4.1 获取id
            String idStr = tuple.getValue();
            ids.add(Long.valueOf(idStr));

            // 4.2 获取分数 (时间戳)
            long time = tuple.getScore().longValue();
            if (time == minTime) {
                os++;
            } else {
                minTime = time;
                os = 1;
            }

        }

        // 5. 根据id查询blog
        String idStr = StrUtil.join(",", ids);
        List<Blog> blogs = query().in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list();

        for (Blog blog : blogs) {
            queryBlogUser(blog);
            isBlockLiked(blog);
        }

        // 6. 封装并返回
        ScrollResult r = new ScrollResult();
        r.setList(blogs);
        r.setOffset(os);
        r.setMinTime(minTime);


        return Result.ok(r);
    }

}
