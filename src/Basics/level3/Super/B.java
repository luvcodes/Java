package Basics.level3.Super;

public class B extends A{
    // 访问父类的属性，但不能访问父类的private属性。super.属性名
    public void hi() {
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }
    // 访问父类的方法，不饿能访问父类的private方法。super.方法名
    public void ok() {
        super.test100();
        super.test200();
        super.test300();
//        super.test400(); // 不能访问父类private方法
    }
    // 访问父类的构造器：super(参数列表);只能放在构造器的第一句，只能出现一句
    public B() {
        super(); // 这样就是调用的父类的无参构造器
//        super("jack"); // 这样就是调用的父类的一个参数的构造器
        // super("jack", 10); // 这样就是调用的父类的两个参数的构造器
    }

}
