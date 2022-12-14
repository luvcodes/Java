package Basics.Homework.Homework06;
/**
 * 假定Grand，Father和Son在同一个包，问：父类和子类中通过this和super都可以调用哪些属性和方法
 * </p>
 * this（对象本身）可以访问自己的所有（非静态）成员，和父类及以上，除了private修饰、静态、覆盖的成员
 * super（父类对象）可以访问父类及以上，除了private修饰、静态、覆盖的成员
 * */
public class Homework06 {
}

class Grand {
    String name = "AA";
    private int age = 100;
    public void g1() {}
}

class Father extends Grand {
    String id = "001";
    private double score;
    public void f1() {
//        // super可以访问哪些成员（属性和方法）
//        super.name;
//        super.g1();
//        // this可以访问哪些成员？
//        this.id;
//        this.score;
//        this.f1();
//        this.name;
//        this.g1();
    }
}

class Son extends Father {
    String name = "BB";
    public void g1() {}
    private void show() {
//        // super可以访问哪些成员（属性和方法）？
//        super.id;
//        super.f1();
//        super.name;
//        super.g1();
//        // this可以访问哪些成员？
//        this.name;
//        this.g1();
//        this.show();
//        this.id;
//        this.f1();
    }
}
