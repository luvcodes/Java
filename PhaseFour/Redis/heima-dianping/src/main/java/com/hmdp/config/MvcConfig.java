package com.hmdp.config;

import com.hmdp.utils.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ryanw
 */
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "shop/**",
                        "shop-type/**",
                        "upload/**",
                        "voucher/**",
                        "/blog/hot",
                        "/user/code",
                        "/user/login"
                );
    }
}
