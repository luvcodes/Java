package com.hmall.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmall.cart.domain.dto.CartFormDTO;
import com.hmall.cart.domain.po.Cart;
import com.hmall.cart.domain.vo.CartVO;
import java.util.Collection;
import java.util.List;

/**
 * 订单详情表 服务类
 * @author ryanw
 */
public interface ICartService extends IService<Cart> {

    void addItem2Cart(CartFormDTO cartFormDTO);

    List<CartVO> queryMyCarts();

    void removeByItemIds(Collection<Long> itemIds);
}
