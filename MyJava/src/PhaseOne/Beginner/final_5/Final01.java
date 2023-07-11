package PhaseOne.Beginner.final_5;

public class Final01 {
    public static void main(String[] args) {
//        E e = new E();
//        e.TAX_RATE = 0.09;


    }
}

/*
* 如果我们要求A类不能被其他类继承，可以使用final修饰A类
* */
final class A {

}

//class B extends A {}

class C {
    // 如果我们要求hi不能被子类重写
    // 可以使用final修饰 hi()方法
    public void hi() {}
}

class D extends C {
    @Override
    public void hi() {
        System.out.println("Override the hi() method in C class");
    }
}

// 当不希望类的某个属性的值被修改，可以用final修饰
class E {
    public final double TAX_RATE = 0.08;
}

// 当不希望某个局部变量被修改，可以使用final修饰
class F {
    public void cry() {
        // 这时，NUM也称为局部常量
        final double NUM = 0.01;
//        NUM = 0.9;
        System.out.println("NUM = " + NUM) ;
    }
}
