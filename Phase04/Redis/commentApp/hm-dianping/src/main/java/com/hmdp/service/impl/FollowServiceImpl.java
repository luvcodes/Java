package com.hmdp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmdp.dto.Result;
import com.hmdp.entity.Follow;
import com.hmdp.mapper.FollowMapper;
import com.hmdp.service.IFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.UserHolder;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 * @author ryanw
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

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

        // 1. 判断是关注还是取关
        if (isFollow) {
            // 2. 关注，新增数据到tb_follow表
            Follow follow = new Follow();
            follow.setUserId(userId);
            follow.setFollowUserId(followUserId);
            save(follow);
        } else {
            // 3. 取关，删除 delete from tb_follow where userId = ? and follow_user_id = ?
            remove(new QueryWrapper<Follow>().eq("user_id", userId).eq("follow_user_id", followUserId));
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
}
