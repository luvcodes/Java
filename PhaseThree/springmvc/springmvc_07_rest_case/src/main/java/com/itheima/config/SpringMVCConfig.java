package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ryanw
 */
@Configuration
@ComponentScan("com.itheima")
@EnableWebMvc
public class SpringMVCConfig {

}
