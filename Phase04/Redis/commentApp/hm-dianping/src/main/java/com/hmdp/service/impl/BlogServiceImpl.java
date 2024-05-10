package com.hmdp.service.impl;

import cn.hutool.core.util.BooleanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmdp.dto.Result;
import com.hmdp.entity.Blog;
import com.hmdp.entity.User;
import com.hmdp.mapper.BlogMapper;
import com.hmdp.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.service.IUserService;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 根据id查询Blog
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
        Long userId = UserHolder.getUser().getId();

        // 2. 判断当前登录用户是否已经点赞
        String key = "blog:liked:" + blog.getId();
        Boolean isMember = stringRedisTemplate.opsForSet().isMember(key, userId.toString());

        blog.setIsLike(BooleanUtil.isTrue(isMember));
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
     * @param id 当前已经点赞的Blog的id
     * @return 点赞成功与否结果
     */
    @Override
    public Result likeBlog(Long id) {
        // 1. 获取登录用户
        Long userId = UserHolder.getUser().getId();

        // 2. 判断当前登录用户是否已经点赞
        String key = "blog:liked:" + id;
        Boolean isMember = stringRedisTemplate.opsForSet().isMember(key, userId.toString());
        if (BooleanUtil.isFalse(isMember)) {
            // 3. 如果未点赞，可以点赞
            // 3.1 数据库点赞数 + 1
            boolean isSuccess = update().setSql("liked = liked + 1").eq("id", id).update();

            // 3，2 保存用户到redis的set集合
            if (isSuccess) {
                stringRedisTemplate.opsForSet().add(key, userId.toString());
            }

        } else {
            // 4. 如果已点赞，取消点赞
            // 4.1 数据库点赞数 - 1
            boolean isSuccess = update().setSql("liked = liked - 1").eq("id", id).update();

            // 4.2 把用户从redis set集合里移除
            stringRedisTemplate.opsForSet().remove(key, userId.toString());
        }


        return Result.ok();
    }

}
