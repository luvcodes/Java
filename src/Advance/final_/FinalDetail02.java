package Advance.final_;

public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BBB.num); // final和static往往搭配使用，效率更高，不会导致类加载，静态代码块就不会被执行

        // 包装类，String 是final类，不能被继承
    }
}

class BBB {
    public final static int num = 10000;
    static {
        System.out.println("BBB static codeblock has been executed");
    }
}

final class AAA {
    // 一般来说，如果一个类已经是final类了，就没有必要再将方法修饰为final
//    public final void a() {}
}
