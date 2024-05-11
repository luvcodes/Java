package com.hmdp.service;

import com.hmdp.dto.Result;
import com.hmdp.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *  服务类
 * @author ryanw
 */
public interface IFollowService extends IService<Follow> {

    Result follow(Long followUserId, boolean isFollow);

    Result isFollow(Long followUserId);

    Result followCommons(Long id);
}
