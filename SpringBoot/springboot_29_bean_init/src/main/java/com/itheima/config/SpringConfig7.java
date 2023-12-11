package com.itheima.config;

import com.itheima.bean.MyImportSelector;
import com.itheima.bean.MyRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = "com.itheima")
@Import(MyRegistrar.class)
public class SpringConfig7 {
}
