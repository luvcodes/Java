package Advance.interface_.InterfacePoly;

public class InterfacePolyParameter {
    public static void main(String[] args) {
        // 接口的多态体现
        // 接口类型的变量 if01 可以指向实现了IF接口的类的对象实例
        IF if01 = new Monster();
        if01 = new Car();

        // 继承体现的多态
        // 父类类型的变量a 可以指向继承AAA的子类的对象实例
        AAA a = new BBB();
        a = new CCC();
    }
}

interface IF {

}

class Monster implements IF {}

class Car implements IF {}

class AAA {

}

class BBB extends AAA {

}

class CCC extends AAA {

}