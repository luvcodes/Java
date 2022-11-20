package Basics.level2.class_object.method;

public class MethodDetail02 {
    public static void main(String[] args) {
        B b = new B();
        b.sayOk();
        b.m1();
    }
}


class B {
    public void print(int n) {
        System.out.println("print method has been called " + n);
    }

    // 1. 同一个类中的方法调用: 直接调用即可
    public void sayOk() {
        print(10);
        System.out.println("Continue to execute sayOK()~~~");
    }

    // 2. 跨类中的方法B类调用C类方法: 需要通过对象名调用
    public void m1() {
        System.out.println("m1()方法被调用");
        C c = new C();
        c.hi();
        System.out.println("m1继续执行");
    }
}

class C {
    public void hi() {
        System.out.println("C类中的hi()被执行");
    }
}