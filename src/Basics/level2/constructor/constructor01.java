package Basics.level2.constructor;

public class constructor01 {
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
    // 构造器
    // 构造器没有返回值，也不能写void
    // 构造器的名称和类Person
    // String pName, int pAge 是构造器的形参列表，规则和成员方法一样
    public Person(String pName, int pAge) {
        System.out.println("构造器被调用 完成对象的属性初始化");
        name = pName;
        age = pAge;
    }
}