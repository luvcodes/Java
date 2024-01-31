package Reflection.classload_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassLoad_ {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the key: ");
        String key = scanner.next();
        switch (key) {
            case "1":
                /**
                 * 静态加载
                 * 编译时会加载相关的类, 即使没有执行case "1"也会加载这个类。
                 * 相当于就是如果Dog类没有编写，直接在这里创建Dog类的实例是会报错的，即使放在了case语句中
                 * */
                Dog dog = new Dog();
                dog.cry();
                break;
            case "2":
                /**
                 * 动态加载
                 * 当我们运行的时候，而且执行到这段代码的时候，才会加载这个类
                 * */
                Class cls = Class.forName("Person");
                Object o = cls.newInstance();
                Method m = cls.getMethod("hi");
                m.invoke(o);
                System.out.println("OK");
                break;
            default:
                System.out.println("do nothing...");
        }
    }
}

/**
 * 因为new Dog() 是静态加载，因此必须编写Dog类
 * Person类是动态加载，所以，没有编写Person类也不会报错，只有当动态加载该类的时候，才会报错
 * */
class Dog {
    public void cry() {
        System.out.println("Dog cry");
    }
}

class Person {
    public void hi() {
        System.out.println("Person hi");
    }
}
