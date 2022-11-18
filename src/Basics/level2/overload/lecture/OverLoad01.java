package Basics.level2.overload.lecture;

/**
 * java允许同一个类中，多个同名方法的存在，但要求形参列表不一致
 * 比如System.out.println(); out是PrintStream类型
 * <p>
 *
 * 注意事项和使用细节
 * 1) 方法名：必须相同
 * 2) 形参列表：必须不同（形参类型或个数或顺序，至少有一样不同，参数名无要求)
 * 3) 返回类型：无要求
 * <p>
 *
 * 重载的好处：
 * 减轻了起名的麻烦
 * 减轻了记名的麻烦
 * */

public class OverLoad01 {
    public static void main(String[] args) {
        MyCalculator mc = new MyCalculator();
        System.out.println(mc.calculate(1, 2));
        System.out.println(mc.calculate(1.1, 2));
        System.out.println(mc.calculate(1, 2.1));

    }
}

class MyCalculator {
    // 两个整数的和
    public int calculate(int n1, int n2) {
        System.out.println("calculate(int n1, int n2)被调用..");
        return n1 + n2;
    }

//    没有构成，而是方法的重复定义，就错了
//    public int calculate(int a1, int a2) {
//        System.out.println("calculate(int a1, int a2)被调用..");
//        return a1 + a2;
//    }

//    看看下面是否构成重载，没有构成，而是方法的重复定义，就错了
//    public int calculate(int a1, int a2) {
//        System.out.println("calculate(int a1, int a2)被调用..");
//        return a1 + a2;
//    }


    // 一个整数，一个double的和
    public double calculate(int n1, double n2) {
        System.out.println("calculate(int n1, double n2)被调用..");
        return n1 + n2;
    }
    // 一个double，一个int和
    public double calculate(double n2, int n1) {
        System.out.println("calculate(double n2, int n1)被调用..");
        return n2 + n1;
    }
    // 三个int的和
    public int calculate(int n1, int n2, int n3) {
        System.out.println("calculate(int n1, int n2, int n3)被调用..");
        return n1 + n2 + n3;
    }
}
