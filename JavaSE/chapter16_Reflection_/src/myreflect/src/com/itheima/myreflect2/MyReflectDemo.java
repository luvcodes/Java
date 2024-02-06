package com.itheima.myreflect2;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class MyReflectDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    /*
        Class类中用于获取构造方法的方法
            Constructor<?>[] getConstructors()                                返回所有公共构造方法对象的数组
            Constructor<?>[] getDeclaredConstructors()                        返回所有构造方法对象的数组
            Constructor<T> getConstructor(Class<?>... parameterTypes)         返回单个公共构造方法对象
            Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 返回单个构造方法对象

        Constructor类中用于创建对象的方法
            T newInstance(Object... initargs)                                 根据指定的构造方法创建对象
            setAccessible(boolean flag)                                       设置为true,表示取消访问检查
    */

        //1.获取class字节码文件对象
        Class clazz = Class.forName("com.itheima.myreflect2.Student");

        //2.获取构造方法
        // Constructor[] cons1 = clazz.getConstructors();
        // for (Constructor con : cons1) {
        //     System.out.println(con);
        // }
        // Constructor[] cons2 = clazz.getDeclaredConstructors();
        // for (Constructor con : cons2) {
        //     System.out.println(con);
        // }


        // Constructor con1 = clazz.getDeclaredConstructor();
        // System.out.println(con1);

        // Constructor con2 = clazz.getDeclaredConstructor(String.class);
        // System.out.println(con2);

        // Constructor con3 = clazz.getDeclaredConstructor(int.class);
        // System.out.println(con3);

        Constructor con4 = clazz.getDeclaredConstructor(String.class, int.class);
        // System.out.println(con4);

        int modifiers = con4.getModifiers();
        System.out.println(modifiers);


        Parameter[] parameters = con4.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        //暴力反射：表示临时取消权限校验
        // con4.setAccessible(true);
        // Student stu = (Student) con4.newInstance("张三", 23);

        // System.out.println(stu);


    }
}