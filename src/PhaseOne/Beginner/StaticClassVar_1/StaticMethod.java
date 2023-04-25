package PhaseOne.Beginner.StaticClassVar_1;

public class StaticMethod {
    public static void main(String[] args) {
        Stu tom = new Stu("tom");
        tom.payFee(100);

        Stu mary = new Stu("mary");
        mary.payFee(200);

        // 输出当前收到的总学费
        Stu.showFee();

        // 如果我们希望不创建实例，也可以调用某个方法
        // 这时，把方法做成静态方法时非常合适
        System.out.println("The root of 9 is " + Math.sqrt(9));
        System.out.println(MyTools.calSum(10, 30));
    }
}

class MyTools {
    // 求出两个数的和
    public static double calSum(double n1, double n2) {
        return n1 + n2;
    }
}

class Stu {
    private String name; // 普通成员
    // 定义一个静态变量，求累计学生的学费
    private static double fee = 0;
    public Stu(String name) {
        this.name = name;
    }

    // 说明
    // 1. 当方法使用static修饰后，该方法就是静态方法
    // 2. 静态方法就可以访问静态属性/变量
    public static void payFee(double fee) {
        Stu.fee += fee;
    }
    public static void showFee() {
        System.out.println("总学费有: " + Stu.fee);
    }
}