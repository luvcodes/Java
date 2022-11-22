package Basics.level3.inheritance.secondpack;

public class Sub extends Base{
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
