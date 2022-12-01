package Basics.level3.Polymorphic.objectpoly_;

/**
 * 一个对象的编译类型和运行类型可以不一致
 * 编译类型在定义对象时，就确定了，不能改变
 * 运行类型是可以变化的
 * 编译类型看定义时 = 号的左边，运行类型看 = 号的右边
 * */
public class PolyObject {
    public static void main(String[] args) {
        // 体验对象多态特点
        // animal 编译类型就是 Animal，运行类型Dog
        Animal animal = new Dog();
        // 因为运行时，这时就执行到该行时，animal的运行类型时Dog，所以cry就是Dog的cry
        animal.cry();

        // animal 编译类型 Animal，运行类型就是Cat
        Animal animal1 = new Cat();
        animal1.cry();
    }
}
