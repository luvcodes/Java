package Advance.InnerClass.AnonymousInnerClass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}

class Outer05 {
    private int n1 = 99;
    public void f1() {
        // 创建一个基于类的匿名内部类
        // 不能添加访问修饰符，因为它的地位就是一个局部变量
        // 作用域: 仅仅在定义它的方法或代码块中
        Person p = new Person() {
            private int n1 = 88;
            @Override
            public void hi() {
                System.out.println("Anonymous inner class override hi() method");
                // 可以直接访问外部类的所有成员，包含私有的
                System.out.println("n1 value = " + n1 + " outer class n1 = " + Outer05.this.n1);
                // Outer05.this就是调用f1的对象
                System.out.println("Outer05.this hashcode = " + Outer05.this);
            }
        };
        p.hi(); // 动态绑定，运行类型是 Outer05$1

        // 也可以直接调用，因为匿名内部类本身也是返回对象
        new Person() {
            @Override
            public void hi() {
                System.out.println("Anonymous inner class override hi() method, haha...");
            }

            @Override
            public void ok(String str) {
                super.ok(str);
            }
        }.ok("jack");


    }
}

class Person {
    public void hi() {
        System.out.println("Person hi() method");
    }
    public void ok(String str) {
        System.out.println("Person ok() " + str);
    }
}
