package com.itheima.bean;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

//@Component
@Data
@EnableConfigurationProperties(CartoonProperties.class)
public class CartoonCatAndMouse {
    private Cat cat;
    private Mouse mouse;
    private CartoonProperties cartoonProperties;

    /**
     * 下面这样的方法就是为了在application.yml中没有提供部分属性或者是全部属性，
     * 下面这样依然能设定默认值。
     * */
//    public CartoonCatAndMouse(CartoonProperties cartoonProperties) {
//        this.cartoonProperties = cartoonProperties;
//        cat = new Cat();
//        cat.setName(cartoonProperties.getCat() != null &&
//                StringUtils.hasText(cartoonProperties.getCat().getName())
//                ? cartoonProperties.getCat().getName()
//                : "tom");
//        cat.setAge(cartoonProperties.getCat() != null &&
//                cartoonProperties.getCat().getAge() != null
//                ? cartoonProperties.getCat().getAge()
//                : 3);
//        mouse = new Mouse();
//        mouse.setName(cartoonProperties.getMouse() != null &&
//                StringUtils.hasText(cartoonProperties.getMouse().getName())
//                ? cartoonProperties.getMouse().getName()
//                : "jerry");
//        mouse.setAge(cartoonProperties.getMouse() != null &&
//                cartoonProperties.getMouse().getAge()
//                ? cartoonProperties.getMouse().getName()
//                : 4);
//    }

    public void play(){
        System.out.println(cat.getAge() + " year old " + cat.getName() + " and " + mouse.getAge() + " year old " + mouse.getName() + " started to fight");
    }
}
