package com.itheima.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ryanw
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public void deductBalance(Long id, Integer money) {
        // 1. 查询用户
        User user = getById(id);

        // 2. 校验用户状态，正常才可以扣余额
        if (user == null || user.getStatus() == 2) {
            throw new RuntimeException("用户状态异常!");
        }

        // 3. 校验用户余额是否充足
        if (user.getBalance() < money) {
            throw new RuntimeException("用户余额不足!");
        }

        // 4. 扣减余额
//        baseMapper.deductBalance(id, money);
        int remainBalance = user.getBalance() - money;
        lambdaUpdate()
                .set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, 2)
                .eq(User::getId, id)
                // 下面这一行就是实现乐观锁。需要锁的原因是因为在这个deductBalance方法中的逻辑，
                // 先查询，然后进行更新，可能会出现线程并发安全问题。所以下面这个就当做一个where条件，
                // 比较当前用户的balance和更新过后的balance是否相同。如果相同，是正确的; 如果不同，下面根本就不会update。
                .eq(User::getBalance, user.getBalance())
                .update();
    }

    @Override
    public List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance) {
        return lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .gt(minBalance != null, User::getBalance, minBalance)
                .lt(maxBalance != null, User::getBalance, maxBalance)
                .list();
    }
}
