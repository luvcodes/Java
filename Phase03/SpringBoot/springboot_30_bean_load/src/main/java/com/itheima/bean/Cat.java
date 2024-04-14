package com.itheima.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Component;

@Component("tom")
@ConditionalOnNotWebApplication
@ConditionalOnBean(name = "jerry") // 只抓jerry
public class Cat {
}
