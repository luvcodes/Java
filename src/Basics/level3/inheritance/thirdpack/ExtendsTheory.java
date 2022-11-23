package Basics.level3.inheritance.thirdpack;
/**
 * 继承的本质
 * */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();
        // 要按照查找关系来返回信息
        // 首先看子类是否有该属性
        // 如果子类有这个属性，并且可以访问，则返回信息
        // 如果子类没有这个属性，就看父类有没有这个属性（如果父类有该属性，并且可以访问，就返回信息...）
        // 如果父类没有就按照上面一步的规则，继续找上级父类，直到Object...
        System.out.println(son.name);
//        System.out.println(son.age);
        System.out.println(son.getAge());
        System.out.println(son.hobby);
    }
}
class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
}
class Father extends GrandPa {
    String name = "大头爸爸";
    private int age = 39;

    // 如果想在private的情况下访问age

    public int getAge() {
        return age;
    }
}
class Son extends Father {
    String name = "大头儿子";
}