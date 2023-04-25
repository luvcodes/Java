package PhaseOne.Beginner.InnerClass_8.StaticInnerClass;

import PhaseOne.Beginner.InnerClass_8.StaticInnerClass.Outer10.Inner10;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        // 外部其他类，使用静态内部类
        // 方式1: 
        // 因为静态内部类，是可以通过类名直接访问的(前提是满足访问权限)
       Inner10 inner10 = new Outer10.Inner10();
       inner10.say();

       // 方式二: 
       // 编写一个方法，可以返回静态内部类的对象实例
        Inner10 inner101 = outer10.getInner10();
        System.out.println("=============");
        inner101.say();


        Inner10 inner10_ = Outer10.getInner10_();
        System.out.println("***********");
        inner10_.say();
    }
}

class Outer10 {
    private int n1 = 10;
    private static String name = "Jack";
    // Inner10就是静态内部类
    // 1. 放在外部类的成员位置
    // 2. 使用static修饰
    // 3. 可以任意添加外部类的访问修饰符
    // 4. 可以随意访问外部类的所有静态成员，但不能访问非静态成员
    // 5. 作用域: 同其他的成员，为整个整体
    static class Inner10 {
        private static String name = "Mark";
        public void say() {
            System.out.println(name + " outer name: " + Outer10.name);
        }
    }

    public void m1() {
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInner10() {
        return new Inner10();
    }

    public static Inner10 getInner10_() {
        return new Inner10();
    }
}