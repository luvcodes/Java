package PhaseOne.Basics.level2.overload;

public class OverLoadExercise2 {
    public static void main(String[] args) {
        Methods_2 methods = new Methods_2();
        methods.m(2);
        methods.m(2,2);
        methods.m("str");

        System.out.println(methods.max(1, 2));
        System.out.println(methods.max(1.1, 2.2));
        System.out.println(methods.max(1.1, 2.2, 3.3));
    }
}

class Methods_2 {
    /*
     * 定义三个重载方法max()，第一个方法，返回两个int值中的最大值
     * 第二个方法，返回两个double值中的最大值
     * 第三个方法，返回三个double值中的最大值，并分别调用三个方法
     * */

    public int max(int n1, int n2) {
        return Math.max(n1, n2);
    }

    public double max(double n1, double n2) {
        return Math.max(n1, n2);
    }

    public double max(double n1, double n2, double n3) {
        // 求出n1和n2的最大值
        double max1 = Math.max(n1, n2);
        return Math.max(max1, n3);
    }

    public double max(double n1, double n2, int n3) {
        // 求出n1和n2的最大值
        double max1 = Math.max(n1, n2);
        return Math.max(max1, n3);
    }

    /*
     * 类Methods中定义三个重载方法并调用，方法名为m
     * 三个方法分别接受一个int参数，两个int参数，一个字符串参数。分别执行平方计算并输出结果
     * 相乘并输出结果，输出字符串信息。在主类main()方法中分别用参数区别调用三个方法
     * */

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