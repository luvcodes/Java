package Basics.level3.inheritance._exercise;

public class ExtendsExercise01 {
    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    A() {
        System.out.println("a");
    }
    A(String name) {
        System.out.println("a name");
    }
}

class B extends A {
    B() {
        this("abc");
        System.out.println("b");
    }
    B(String name) {
        // 这里默认有一个super()，会默认调用父类的无参构造器
//        super();
        System.out.println("b name");
    }
}
