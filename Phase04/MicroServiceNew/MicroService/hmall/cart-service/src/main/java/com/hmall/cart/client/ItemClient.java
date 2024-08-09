package com.hmall.cart.client;

import com.hmall.cart.domain.dto.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collection;
import java.util.List;

/**
 * @author ryanw
 * OpenFeign的客户端: 通过使用OpenFeign来替代Service类中本来使用的RestTemplate的方式，实现更方便的远程调用
 * */
@FeignClient("item-service")
public interface ItemClient {

    @GetMapping("/items")
    List<ItemDTO> queryItemByIds(@RequestParam Collection<Long> ids);

}
