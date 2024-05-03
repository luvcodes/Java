package com.hmdp.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 *  服务实现类
 * @author ryanw
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryById(Long id) {
        // 1. 从redis查询商铺缓存
        String shopJson = stringRedisTemplate.opsForValue().get(RedisConstants.CACHE_SHOP_KEY + id);

        // 2. 判断商铺缓存信息是否存在于redis中
        if (StrUtil.isNotBlank(shopJson)) {
            // 3. 如果存在商铺，返回商铺信息
            // 这里返回商铺信息之前需要转成java对象返回，而不是字符串
            Shop shop = JSONUtil.toBean(shopJson, Shop.class);
            return Result.ok(shop);
        }

        // 4. 若不存在，根据商铺id查询数据库
        Shop shop = getById(id);

        // 5 如果商铺不存在，返回404
        if (shop == null) {
            return Result.fail("店铺不存在");
        }

        // 6. 如果商铺存在，将商铺信息写入redis，并返回
        stringRedisTemplate.opsForValue().set(RedisConstants.CACHE_SHOP_KEY + id, JSONUtil.toJsonStr(shop));

        // 7. 返回
        return Result.ok(shop);

    }
}
