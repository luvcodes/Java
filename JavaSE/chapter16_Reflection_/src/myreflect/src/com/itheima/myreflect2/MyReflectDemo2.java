package com.itheima.myreflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ryanw
 */
@SuppressWarnings("unchecked")
public class MyReflectDemo2 {
        public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                // 1.获取class字节码文件对象
                Class clazz = Class.forName("com.itheima.myreflect2.Student");

                // 2. 获取构造方法
                // Constructor[] cons1 = clazz.getConstructors();
                // for (Constructor con : cons1) {
                // System.out.println(con);
                // }
                // Constructor[] cons2 = clazz.getDeclaredConstructors();
                // for (Constructor con : cons2) {
                // System.out.println(con);
                // }

                // 2.1
                // Constructor con1 = clazz.getDeclaredConstructor();
                // System.out.println(con1);

                // 2.2
                // Constructor con2 = clazz.getDeclaredConstructor(String.class);
                // System.out.println(con2);

                // 2.3
                // Constructor con3 = clazz.getDeclaredConstructor(int.class);
                // System.out.println(con3);

                // 2.4
                Constructor con4 = clazz.getDeclaredConstructor(String.class, int.class);
                // System.out.println(con4);

                // 获取构造方法的权限修饰符
                // 修饰符本身是根据java的设置，不同的修饰符对应不同的数字
                // int modifiers = con4.getModifiers();
                // System.out.println(modifiers);

                // 获取构造方法参数的个数
                // Parameter[] parameters = con4.getParameters();
                // for (Parameter parameter : parameters) {
                // System.out.println(parameter);
                // }

                // 暴力反射：表示临时取消权限校验
                con4.setAccessible(true);
                Student stu = (Student) con4.newInstance("张三", 23);

                System.out.println(stu);
        }
}