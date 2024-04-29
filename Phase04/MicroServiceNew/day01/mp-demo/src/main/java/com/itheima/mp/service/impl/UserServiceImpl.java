package com.itheima.mp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.Address;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.AddressVO;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.enums.UserStatus;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

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
        if (user == null || user.getStatus() == UserStatus.FROZEN) {
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
                .set(remainBalance == 0, User::getStatus, UserStatus.FROZEN)
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

    @Override
    public UserVO queryUserAndAddressById(Long id) {
        // 1. 查询用户
        User user = getById(id);
        if (user == null || user.getStatus() == UserStatus.FROZEN) {
            throw new RuntimeException("用户状态异常");
        }

        // 2. 查询地址
        List<Address> addresses = Db.lambdaQuery(Address.class)
                // Address里面的userid等于当前传入的id
                .eq(Address::getUserId, id)
                .list();

        // 3. 封装VO
        // 3.1 转User的PO为VO
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        // 3.2 转AddressVO
        if (CollUtil.isNotEmpty(addresses)) {
            userVO.setAddresses(BeanUtil.copyToList(addresses, AddressVO.class));
        }

        return userVO;
    }

    @Override
    public List<UserVO> queryUserAndAddressByIds(List<Long> ids) {
        // 1. 查询用户
        List<User> users = listByIds(ids);
        if (CollUtil.isEmpty(users)) {
            return Collections.EMPTY_LIST;
        }
        // 2. 查询地址
        // 2.1 获取用户id集合
        List<Long> userIds = users.stream().map(User::getId).collect(Collectors.toList());
        // 2.2 根据用户id查询地址
        List<Address> addresses = Db.lambdaQuery(Address.class)
                .in(Address::getUserId, userIds).list();
        // 2.3 转换成AddressVO
        List<AddressVO> addressVOList = BeanUtil.copyToList(addresses, AddressVO.class);
        // 2.4 对用户地址集合进行分组，分类整理，相同用户放入一个集合中
        Map<Long, List<AddressVO>> addressMap = new HashMap<>(0);
        if (CollUtil.isNotEmpty(addresses)) {
            addressMap = addressVOList.stream().collect(Collectors.groupingBy(AddressVO::getUserId));
        }

        // 3. 转VO返回
        // 3.1
        List<UserVO> list = new ArrayList<>(users.size());
        for (User user : users) {
            // 3.1 转UserPO成UserVO
            UserVO vo = BeanUtil.copyProperties(user, UserVO.class);
            list.add(vo);
            // 3.2 转换AddressPO到AddressVO
            vo.setAddresses(addressMap.get(user.getId()));
        }

        return list;
    }

    /**
     * 实现通用分页实体
     * */
    @Override
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {
        // 这里设置成包装类型的原因是为了能够处理 null 值，基本数据类型 int 无法处理 null 值，而这在数据库操作中很重要。
        String name = query.getName();
        Integer status = query.getStatus();

        // 1. 构建分页条件
        Page<User> page = query.toMpPageDefaultSortByUpdateTime();

        // 2. 分页查询
        Page<User> p = lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .page(page);

        // 3. 封装VO结果
        return PageDTO.of(p, user -> {
            // 1. 拷贝基础属性
            UserVO vo = BeanUtil.copyProperties(user, UserVO.class);

            // 2. 处理特殊逻辑
            // 举例子来说，想把username最后两位隐藏
            vo.setUsername(vo.getUsername().substring(0, vo.getUsername().length() - 2) + "**");
            return vo;
        });
    }
}
