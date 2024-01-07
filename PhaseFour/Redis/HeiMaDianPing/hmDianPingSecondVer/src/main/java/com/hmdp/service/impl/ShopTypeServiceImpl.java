package com.hmdp.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    // 店铺类型添加缓存
    @Override
    public Result queryTypeList() {
        // 从redis查询商户缓存
        String shopJson = stringRedisTemplate.opsForValue().get("shop_type_list");
        // 判断是否存在
        if (StrUtil.isNotBlank(shopJson)) {
            // 存在，直接返回
            List<ShopType> shopTypes = JSONUtil.toList(shopJson, ShopType.class);
            return Result.ok(shopTypes);
        }
        // 不存在，查询数据库
        List<ShopType> shopTypes = query().orderByAsc("sort").list();
        // 不存在，返回错误
        if (shopTypes == null) {
            return Result.fail("查询失败");
        }
        // 存在，写入redis
        stringRedisTemplate.opsForValue().set("shop_type_list", JSONUtil.toJsonStr(shopTypes));
        // 返回
        return Result.ok(shopTypes);
    }
}
