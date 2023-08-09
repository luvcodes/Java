package Polymorphic.polyDetail_;

public class PolyDetail {
    public static void main(String[] args) {
        /**
         * 向上转型: 父类的引用指向子类的对象
         * 语法: 父类类型引用名 = new 子类类型();
         * */
        Animal animal = new Cat();
        // 这个也可以，Object是顶级父类，也是Cat的父类
        Object object = new Cat();

        /**
         * 向上转型调用方法的规则如下:
         * (1) 可以调用父类中的所有成员 (需遵守访问权限)
         * (2) 但是不能调用子类的特有的成员
         * 因为在编译阶段，能调用哪些成员，是由编译类型来决定的
         * animal.catchMouse(); 错误, 因为编译器会觉得这个catchMouse方法应该是写在编译类型里面的，也就是Animal类里，可是现在没有
         * (4) 最终运行效果看子类(运行类型)的具体实现，即调用方法时，按照从子类(运行类型)开始查找方法
         * 然后调用，规则和前面讲的方法调用规则一致。
         * */
        animal.eat();
        animal.run();
        animal.sleep();
        animal.show();
        // animal.catchMouse(); // 这样是不允许的

        //调用Cat的 catchMouse方法
        /**
         * 多态的向下转型
         * 1. 语法: 子类类型 引用名 =（子类类型）父类引用;
         * 问一个问题? cat 的编译类型 Cat,运行类型是 Cat
         * */
        Cat cat = (Cat) animal;
        cat.catchMouse();
        //(2)要求父类的引用必须指向的是当前目标类型的对象
        // 也就是说原来的animal对象指向的就是Cat类型的，不能指向Dog类型。
        Dog dog = (Dog) animal; //可以吗？

        System.out.println("ok~~");
    }
}
