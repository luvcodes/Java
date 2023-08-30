package StaticClassVar;

public class StaticDetail {
    public static void main(String[] args) {
        // 类名.类变量名
        // 说明: 类变量是随着类的加载而创建，所以即使没有创建对象实例也可以访问
        System.out.println(B.name);

        B b = new B();
        // 通过对象名.类变量名
        System.out.println("b.name = " + b.name);
    }
}

class B {
    // 类变量
    public static String name = "Ryan";

    // 普通属性、普通成员变量、非静态属性、非静态成员变量、实例变量
    private int num = 10;
}