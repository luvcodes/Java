package com.itheima.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        /**
         * 根据任意条件确认是否加载bean
         * </p>
         * 判断当前环境有没有某个类，也就是下面的aClass的className部分
         * 这就是控制bean加载
         * */
        try {
            Class<?> aClass = Class.forName("com.itheima.bean.Mouse");
            if (aClass != null) { // 证明加载上了Mouse
                return new String[]{"com.itheima.bean.Cat"};
            }
        } catch (ClassNotFoundException e) {
            return new String[0];
        }
        return null;
    }
}
