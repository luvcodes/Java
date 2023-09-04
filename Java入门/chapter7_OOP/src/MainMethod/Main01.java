package MainMethod;

public class Main01 {
    // 静态的变量/属性
    private static String name = "Ryan";
    // 非静态的变量/属性
    private int n1 = 10000;

    // 静态方法
    public static void hi() {
        System.out.println("Main01的 hi方法");
    }
    // 非静态方法
    private void cry() {
        System.out.println("Main01的 cry方法");
    }

    public static void main(String[] args) {
        // 可以直接使用name
        // 1. 静态方法可以访问本类的静态成员
        System.out.println("name " + name);
        hi();

        // 2. 静态方法main 不可以访问本类的非静态成员
        // System.out.println("n1 = " + n1);
        // cry(); // 也不可以访问本类的非静态方法

        // 3. 静态方法main 要访问本类的非静态成员，需要先创建对象，再调用即可
        Main01 main01 = new Main01();
        System.out.println(main01.n1);
        main01.cry();
    }
}
