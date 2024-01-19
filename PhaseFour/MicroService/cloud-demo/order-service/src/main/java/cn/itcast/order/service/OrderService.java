package cn.itcast.order.service;


import cn.cast.feign.clients.UserClient;
import cn.cast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ryanw
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1. 查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 利用feign发起http请求，查询用户
        User user = userClient.findById(order.getUserId());
        // 3. 封装user到Order
        order.setUser(user);
        // 4. 返回
        return order;
    }


    // 因为完成了UserClient接口，feign远程调用，就不需要了
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//
//        // 2. 利用RestTemplate发起http请求，查询用户
//        // 2.1 url路径
//        // 这里是因为学习了eureka之后，不想要硬编码，所以改成userservice
//        String url = "http://userservice/user/" + order.getUserId();
//        // 2.2 发起请求，并返回 User对象，会自动地把json反序列化成user类型
//        User user = restTemplate.getForObject(url, User.class);
//
//        // 3. 封装user到Order
//        order.setUser(user);
//
//        // 4.返回
//        return order;
//    }
}
