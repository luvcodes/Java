package cn.itcast.autoconfig;

import cn.itcast.service.IpCountService;
import org.springframework.context.annotation.Bean;

public class IpAutoConfiguration {
    @Bean
    public IpCountService ipCountService() {

        return new IpCountService();
    }
}
