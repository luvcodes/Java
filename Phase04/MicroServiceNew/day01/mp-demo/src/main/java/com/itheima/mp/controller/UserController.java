package com.itheima.mp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.itheima.mp.domain.dto.UserFormDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ryanw
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户管理借口")
@RequiredArgsConstructor
public class UserController {

    // 这里可以使用Autowired，但是Spring不推荐这样做。所以使用创建实例对象的方式。
    private final IUserService userService;

    /**
     * 新增用户
     * */
    @PostMapping
    @ApiOperation("新增用户接口")
    public void saveUser(@RequestBody UserFormDTO userDTO) {
        // 1. UserFormDTO拷贝到PO
        // 使用的是hutool工具中的 (依赖可以看到) copyProperties方法，将将DTO对象拷贝到user这种PO对象中。
        User user = BeanUtil.copyProperties(userDTO, User.class);
        // 2. 新增
        userService.save(user);
    }

    /**
     * 删除用户
     * */
    @DeleteMapping("{id}")
    @ApiOperation("删除用户接口")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.removeById(id);
    }

//    /**
//     * 根据id查询用户
//     * */
//    @GetMapping("{id}")
//    @ApiOperation("根据id查询用户接口")
//    public UserVO queryUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
//        // 1. 查询用户PO
//        User user = userService.getById(id);
//        // 2. 把PO拷贝到VO，因为要显示出来，所以需要转换PO成VO
//        return BeanUtil.copyProperties(user, UserVO.class);
//    }

    /**
     * 根据id查询用户
     * 更新版方法，查询user信息的同时要查询出相应的address信息
     * */
    @GetMapping("{id}")
    @ApiOperation("根据id查询用户接口")
    public UserVO queryUserById(@ApiParam("用户id") @PathVariable("id") Long id) {
        return userService.queryUserAndAddressById(id);
    }

//    /**
//     * 根据id批量查询用户
//     * */
//    @GetMapping
//    @ApiOperation("根据id批量查询用户接口")
//    public List<UserVO> queryUserByIds(@ApiParam("用户id集合") @RequestParam("ids") List<Long> ids) {
//        List<User> users = userService.listByIds(ids);
//        return BeanUtil.copyToList(users, UserVO.class);
//    }

    /**
     * 根据id批量查询用户
     * 更新版方法，查询user信息的同时要查询出相应的address信息
     * */
    @GetMapping
    @ApiOperation("根据id批量查询用户接口")
    public List<UserVO> queryUserByIds(@ApiParam("用户id集合") @RequestParam("ids") List<Long> ids) {
        return userService.queryUserAndAddressByIds(ids);
    }

    /**
     * 扣减用户余额接口
     */
    @PutMapping("/{id}/deduction/{money}")
    @ApiOperation("扣减用户余额接口")
    public void deductMoneyById(@ApiParam("用户id") @PathVariable("id") Long id,
                                @ApiParam("扣减的金额") @PathVariable("money") Integer money) {

        userService.deductBalance(id, money);
    }

    /**
     * 根据复杂条件查询用户接口
     */
    @GetMapping("/list")
    @ApiOperation("根据复杂条件查询用户接口")
    public List<UserVO> queryUsers(UserQuery userQuery) {
        // 1. 查询用户PO
        List<User> users = userService.queryUsers(userQuery.getName(), userQuery.getStatus(), userQuery.getMinBalance(), userQuery.getMaxBalance());
        // 2. 将PO转换成UserVO的格式
        return BeanUtil.copyToList(users, UserVO.class);
    }
}
