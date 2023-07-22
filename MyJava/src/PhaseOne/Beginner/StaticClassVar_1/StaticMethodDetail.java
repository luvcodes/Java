package PhaseOne.Beginner.StaticClassVar_1;

public class StaticMethodDetail {
    public static void main(String[] args) {
        D.hi();
//        D.say(); // 错误，需要先创建对象，再调用。非静态方法，不能通过类名调用
        new D().say(); // ok
    }
}

class D {
    private int n1 = 100;
    private static int n2 = 200;

    // 非静态方法，普通方法
    public void say() {}

    public static void hi() {
        // 类方法中不允许使用和对象有关的关键字，
        // 比如this和super。普通方法(成员方法)可以。
//        System.out.println(this.n1);
    }

    // 类方法(静态方法)中 只能访问 静态变量 或静态方法
    // 口诀: 静态方法只能访问静态成员
    public static void hello() {
        System.out.println(n2);
        System.out.println(D.n2);
        // System.out.println(this.n2); // 错误 不能使用
        hi();
        // say(); // 非静态方法 不能用在静态的上下文
    }

    // 普通成员方法，既可以访问非静态成员，也可以访问静态成员
    // 口诀: 非静态方法可以访问静态成员和非静态成员
    public void ok() {
        // 非静态成员
        System.out.println(n1);
        say();
        // 静态成员
        System.out.println(n2);
        hi();
        hello();
    }
}
