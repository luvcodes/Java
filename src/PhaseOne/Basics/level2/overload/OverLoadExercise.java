package PhaseOne.Basics.level2.overload;

public class OverLoadExercise {
    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.m(2);
        methods.m(2,2);
        methods.m("str");
    }
}

/*
* 类Methods中定义三个重载方法并调用，方法名为m
* 三个方法分别接受一个int参数，两个int参数，一个字符串参数。分别执行平方计算并输出结果
* 相乘并输出结果，输出字符串信息。在主类main()方法中分别用参数区别调用三个方法
* */

class Methods {
    // 1. 方法名 m
    // 2. 形参（int）
    // 3. void
    public void m(int n) {
        System.out.println("square = " + (n*n));
    }

    // 1. 方法名 m
    // 2. 形参 （int，int）
    // 3. void
    public void m(int n1, int n2) {
        System.out.println("Multiply = " + (n1*n2));
    }

    // 1. 方法名 m
    // 2. 形参 （String）
    // 3. void
    public void m(String str) {
        System.out.println("传入的str = " + str);

    }
}