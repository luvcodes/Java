package constructor;

/**
 * 一个类可以定义多个不同的构造器，即构造器重载
 * 构造器名和类名要相同
 * 构造器没有返回值
 * 构造器是完成对象的初始化，并不是创建对象
 * 在创建对象时，系统自动地调用该类的构造方法
 * */

public class Constructor01 {
    public static void main(String[] args) {
        // 当我们new 一个对象时，直接通过构造器指定名字和年龄
        Person person = new Person("Smith", 80);
        System.out.println("p1的信息如下");
        System.out.println("p1对象name = " + person.name);
        System.out.println("p1对象age = " + person.age);
    }
}

class Person {
    String name;
    int age;

    // 构造器没有返回值，也不能写void
    // 构造器的名称和类Person
    // String pName, int pAge 是构造器的形参列表，规则和成员方法一样
    public Person(String pName, int pAge) {
        System.out.println("构造器被调用 完成对象的属性初始化");
        name = pName;
        age = pAge;
    }
}