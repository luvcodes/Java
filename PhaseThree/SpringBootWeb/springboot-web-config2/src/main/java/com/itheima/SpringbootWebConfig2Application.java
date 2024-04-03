package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author ryanw
 */
//@ComponentScan({"com.itheima", "com.example"})
// 导入普通类, 导入配置类, 导入ImportSelector接口实现类
//@Import({TokenParser.class, HeaderConfig.class, MyImportSelector.class})
@EnableHeaderConfig
@SpringBootApplication
public class SpringbootWebConfig2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfig2Application.class, args);
    }

//    //声明第三方bean
//    @Bean //将当前方法的返回值对象交给IOC容器管理, 成为IOC容器bean
//    public SAXReader saxReader(){
//        return new SAXReader();
//    }
}
