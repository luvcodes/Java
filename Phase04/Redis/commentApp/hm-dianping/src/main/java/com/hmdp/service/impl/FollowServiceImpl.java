package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.Follow;
import com.hmdp.mapper.FollowMapper;
import com.hmdp.service.IFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.service.IUserService;
import com.hmdp.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  服务实现类
 * @author ryanw
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private IUserService userService;

    /**
     * 关注、取关功能
     * @param followUserId 被关注的user id
     * @param isFollow 判断是否关注
     * @return Result类规范输出
     */
    @Override
    public Result follow(Long followUserId, boolean isFollow) {
        // 获取登录用户
        Long userId = UserHolder.getUser().getId();
        String key = "follows:" + userId;

        // 1. 判断是关注还是取关
        if (isFollow) {
            // 2. 关注，新增数据到tb_follow表
            Follow follow = new Follow();
            follow.setUserId(userId);
            follow.setFollowUserId(followUserId);
            boolean isSuccess = save(follow);
            if (isSuccess) {
                // 把关注用户的id，放入redis的set集合 sadd userId followUserId
                stringRedisTemplate.opsForSet().add(key, followUserId.toString());
            }
        } else {
            // 3. 取关，删除 delete from tb_follow where userId = ? and follow_user_id = ?
            boolean isSuccess = remove(new QueryWrapper<Follow>().eq("user_id", userId).eq("follow_user_id", followUserId));
            if (isSuccess) {
                // 把关注的用户的id从redis中移除
                stringRedisTemplate.opsForSet().remove(key, followUserId.toString());
            }
        }


        return Result.ok();
    }

    /**
     * 判断是否关注
     * @param followUserId 被关注的user id
     * @return Result规范化输出
     */
    @Override
    public Result isFollow(Long followUserId) {
        // 1. 获取登录用户
        Long userId = UserHolder.getUser().getId();

        // 2. 查询是否关注 select count(*) from tb_follow where userId = ? and follow_user_id = ?
        Integer count = query().eq("user_id", userId).eq("follow_user_id", followUserId).count();

        // 3. 判断
        return Result.ok(count > 0);
    }

    /**
     * 共同关注
     * @param id 目标用户的id
     * @return Result规范输出格式
     */
    @Override
    public Result followCommons(Long id) {
        // 1. 获取当前用户
        Long userId = UserHolder.getUser().getId();
        String key = "follows:" + userId;

        // 2. 求交集
        String key2 = "follows:" + id;
        // SINTER set1 set2 返回set1和set2的交集元素
        Set<String> intersect = stringRedisTemplate.opsForSet().intersect(key, key2);
        if (intersect == null) {
            // 无交集
            return Result.ok(Collections.emptyList());
        }

        // 3. 解析id集合
        List<Long> ids = intersect.stream().map(Long::valueOf).collect(Collectors.toList());

        // 4. 查询用户
        Stream<UserDTO> users = userService.listByIds(ids).stream().map(user -> BeanUtil.copyProperties(user, UserDTO.class));
        return Result.ok(users);
    }
}
