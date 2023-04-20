package Advance.interface_;

public interface AInterface {
    // 可以写属性
    public int n1 = 10;
    // 也可以写方法
    // 在接口中，抽象方法可以省略abstract关键字
    public abstract void hi();

    // 在jdk8后，可以有默认实现方法，需要使用default关键字修饰
    default public void ok() {
        System.out.println("ok...");
    }

    // 可以有静态方法, 可以是实现的
    public static void cry() {
        System.out.println("cry...");
    }
}
