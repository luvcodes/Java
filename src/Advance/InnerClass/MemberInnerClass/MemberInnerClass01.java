package Advance.InnerClass.MemberInnerClass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        // 外部其他类，使用成员内部类的三种方式
        // 1. 第一种方式
        // outer08.new Inner08(); 相当于把Inner08()当做是outer08的一个成员
        // 这就是一个语法，不要特别的纠结
        Outer08.Inner08 inner08 = outer08.new Inner08();

        // 2. 第二种方式
        // 在外部类中，编写一个方法，可以返回Inner08对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();
    }
}

class Outer08 {
    private int n1 = 10;
    public String name = "Jack";

    public void hi() {
        System.out.println("hi() method...");
    }

    // 1. 成员内部类, 定义在外部类的成员位置上
    // 2. 可以添加任意访问修饰符
    class Inner08 {
        private double sal = 99.9;

        public void say() {
            // 可以直接访问外部类的所有成员，包含私有的
            System.out.println("Outer08 n1 = " + n1 + " name = " + name);
        }
    }

    // 方法，返回Inner08实例
    public Inner08 getInner08Instance() {
        return new Inner08();
    }

    // 写方法
    public void t1() {
        // 使用成员内部类
        // 创建成员内部类的对象，然后使用相关的方法和属性
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }
}
