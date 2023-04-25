package PhaseOne.Advance.Homework;

public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        /**
         * 匿名内部类是
         * new Calculator() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }，同时也是一个对象
         * 它的编译类型 Calculator，它的运行类型就是匿名内部类，也就是下面重写的work方法
         */
        cellphone.testwork(new Calculator() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 10, 8);
    }
}

/**
 * 1. 计算器接口具有work方法，功能是运算，有一个手机类Cellphone，定义方法testWork测试计算功能，调用计算接口的work方法
 * 2. 要求调用CellPhone对象的testWork方法，使用上匿名内部类
 */

interface Calculator {
    public double work(double n1, double n2);
}

class Cellphone {
    // 当我们调用testWork方法时，直接传入一个实现了Calculator接口的匿名内部类即可
    // 该匿名内部类
    public void testwork(Calculator calculator, double n1, double n2) {
        double result = calculator.work(n1, n2);
        System.out.println("Result: " + result);
    }
}