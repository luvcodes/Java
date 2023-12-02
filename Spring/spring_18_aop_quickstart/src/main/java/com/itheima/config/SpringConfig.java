package com.itheima.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.itheima")
@EnableAspectJAutoProxy // 告诉Spring我这里面有注解开发的bean，也就是MyAdvice里面的@Aspect
public class SpringConfig {}
