package Advance.InnerClass.MemberInnerClass;

public class MemberInnerClass
{
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();
    }
}

class Outer08 {
    private int n1 = 10;
    public String name = "Jack";

    // 1. 成员内部类, 定义在外部类的成员位置上
    // 2. 可以添加任意访问修饰符
    class Inner08 {
        public void say() {
            // 可以直接访问外部类的所有成员，包含私有的
            System.out.println("Outer08 n1 = " + n1 + " name = " + name);
        }
    }

    // 写方法
    public void t1() {
        // 使用成员内部类
        Inner08 inner08 = new Inner08();
        inner08.say();
    }
}
