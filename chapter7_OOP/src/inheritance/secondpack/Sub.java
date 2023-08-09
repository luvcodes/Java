package inheritance.secondpack;

// 想要验证类的继承关系，输入ctrl + H
public class Sub extends Base{
    public Sub(String name, int age) {
        // 1. 调用父类的无参构造器, 如下 或者 什么都不写，默认就是调用
//        super();
        // 2. 调用父类的Base(String name)构造器
//        super("hsp");
        // 3. 调用父类的Base(String name, int age)构造器
        super("hsp", 10);
        System.out.println("子类Sub(String name, int age)构造器被调用...");
    }


    // 无参数构造器
    public Sub() {
//        super(); // 默认调用父类的无参构造器
        super("smith", 10);
        System.out.println("子类Sub()构造器被调用...");
    }


    // 当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
    public Sub(String name) {
        super("tom", 30); // 默认调用父类的无参构造器
        // 无参数构造器
        System.out.println("子类Sub(String name)构造器被调用...");
    }


    public void sayOk() {
        // n4不能引用
        // 非私有的属性和方法可以在子类直接访问
        // 但是私有属性和方法不能在子类直接访问
        System.out.println(n1 + " " + n2 + " " + n3);
        test100();
        test200();
        test300();
//        test400(); // 错误
        // 要通过父类提供公共弄的方法去访问
        System.out.println("n4 = " + getN4());
        callTest400();
    }
}
