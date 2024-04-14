package cn.cast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author ryanw
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        // 日志级别，BASIC、HEADERS、FULL，默认为BASIC
        return Logger.Level.BASIC;
    }
}
