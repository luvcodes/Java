package com.hmdp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 服务实现类
 *
 * @author ryanw
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @return Result成功与否结果
     */
    @Override
    public Result queryShopTypeList() {
        // 1. 从redis查询商铺类型信息的缓存
        List<String> shopTypeJson = stringRedisTemplate.opsForList().range(RedisConstants.CACHE_SHOP_TYPE_KEY, 0, -1);

        // 2. 判断商户信息缓存是否在redis中存在
        if (CollectionUtil.isNotEmpty(shopTypeJson)) {
            // 3. 如果存在商铺信息，则直接使用List类型接收并返回
            // 使用java对象类型进行返回，而不是字符串
            // 这里解决一下缓存穿透可能存入空对象
            if (StrUtil.isBlank(shopTypeJson.get(0))) {
                return Result.fail("商品类型信息为空");
            }

            // 转换List<String> -> List<ShopType>并返回
            List<ShopType> shopTypeList = new ArrayList<>();
            for (String jsonString : shopTypeJson) {
                ShopType shopType = JSONUtil.toBean(jsonString, ShopType.class);
                shopTypeList.add(shopType);
            }

            return Result.ok(shopTypeList);
        }

        // 4. 如果redis中不存在商户类型信息，根据商铺类型id (Long)向数据库中查询
        List<ShopType> shopTypeList = query().orderByAsc("sort").list();

        // 5. 如果数据库中也不存在商户类型信息，返回404
        if (CollectionUtil.isEmpty(shopTypeList)) {
            // 添加空对象到redis，解决缓存穿透
            stringRedisTemplate.opsForList().rightPushAll(RedisConstants.CACHE_SHOP_TYPE_KEY, CollectionUtil.newArrayList(""));
            stringRedisTemplate.expire(RedisConstants.CACHE_SHOP_TYPE_KEY, RedisConstants.CACHE_NULL_TTL, TimeUnit.MINUTES);

            return Result.fail("商品分类信息为空");
        }

        // 6. 如果数据库中存在商户类型信息，写回到redis中，并返回
        // 转换List<ShopType> -> List<String>
        ArrayList<String> typeList = new ArrayList<>();
        for (ShopType shopType : shopTypeList) {
            String jsonStr = JSONUtil.toJsonStr(shopType);
            typeList.add(jsonStr);
        }

        stringRedisTemplate.opsForList().rightPushAll(RedisConstants.CACHE_SHOP_TYPE_KEY, typeList);

        // 7. 返回
        return Result.ok(typeList);
    }
}
