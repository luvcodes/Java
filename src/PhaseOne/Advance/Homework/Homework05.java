package PhaseOne.Advance.Homework;

public class Homework05 {
    public static void main(String[] args) {
        new A().f1();
    }
}

/**
 * 编写一个类A，在类中定义局部内部类B，B中有一个私有final常量name，有一个方法show()打印常量name，有一个方法show()打印常量name。
 * A中也定义一个私有的变量name，输出
 */
class A 
{
    private String name = "hello";
    private String NAME = "world";

    public void f1() {

        class B { // 局部内部类
            private final String NAME = "Mark";
            public void show() {
                System.out.println("Name: " + NAME + " outer class name: " + name + " outer class same name: " + A.this.NAME);
            }
        }

        B b = new B();
        b.show();
    }


}
