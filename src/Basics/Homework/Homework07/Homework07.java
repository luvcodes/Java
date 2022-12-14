package Basics.Homework.Homework07;

public class Homework07 {
}

class Test {
    String name = "Rose";
    Test() {
        System.out.println("Test"); // (1)
    }
    Test(String name) { // name形参应该是john
        this.name = name; // 这里把父类的 name 修改 john
    }
}

class Demo extends Test {
    String name = "Jack";
    Demo() {
        super(); // 这里不写，默认也有，找父类无参构造器
        System.out.println("Demo"); // (2)
    }
    Demo(String s) {
        super(s);
    }
    public void test() {
        System.out.println(super.name); // (3) Rose (5) John
        System.out.println(this.name); // (4) Jack (6) Jack
    }

    public static void main(String[] args) {
        new Demo().test();
        new Demo("john").test();
    }
}