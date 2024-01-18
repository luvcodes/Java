package cn.itcast.order;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate并注入spring容器
     * 这样是为了帮助实现发送http请求，在获取order的时候获得user的信息
     * */
    @Bean
    @LoadBalanced // 这是因为eureka实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 改变负载均衡规则，从轮询改成随机
//    @Bean
//    public IRule randomRule() {
//        return new RandomRule();
//    }

}