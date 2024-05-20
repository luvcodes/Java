package com.heima.item.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heima.item.pojo.Item;
import com.heima.item.pojo.ItemStock;
import com.heima.item.service.IItemService;
import com.heima.item.service.IItemStockService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ryanw
 */
public class RedisHandler implements InitializingBean {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private IItemService itemService;

    @Resource
    private IItemStockService stockService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 这个方法会在Bean创建完，Autowired/Resource注入成功之后执行
     * 这样就可以在项目启动的时候执行了，实现了缓存预热的效果。
     * */
    @Override
    public void afterPropertiesSet() throws Exception {
        // 初始化缓存
        // 1. 查询商品信息
        List<Item> itemList = itemService.list();

        // 2. 放入缓存
        for (Item item : itemList) {
            // 2.1 item序列化为json
            String json = MAPPER.writeValueAsString(item);

            // 2.2 存入redis
            stringRedisTemplate.opsForValue().set("item:id" + item.getId(), json);
        }

        // 3. 查询商品库存信息
        List<ItemStock> itemStockList = stockService.list();

        // 4. 放入缓存
        for (ItemStock itemStock : itemStockList) {
            // 4.1 item序列化为json
            String json = MAPPER.writeValueAsString(itemStock);

            // 4.2 存入redis
            stringRedisTemplate.opsForValue().set("stock:id" + itemStock.getId(), json);
        }

    }
}
