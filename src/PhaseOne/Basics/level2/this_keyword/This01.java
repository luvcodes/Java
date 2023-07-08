package PhaseOne.Basics.level2.this_keyword;

/**
 * this在堆内存中是一个印象的属性，指向当前的对象
 * 简单地说，this就是哪个对象调用，this就代表哪个对象
 * */

public class This01 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("tom", 10);
        System.out.println("dog1的hashCode = " + dog1.hashCode());
        dog1.info();
        System.out.println();

        Dog dog2 = new Dog("mike", 3);
        System.out.println("dog2的hashCode = " + dog2.hashCode());
        dog2.info();
    }
}

class Dog {
    String name;
    int age;

    // 出现一个问题，根据变量的作用域原则，
    // 构造器的name 就是局部变量，而不是属性
    // 构造器的age 就是局部变量，而不是属性
//    public Dog(String name, int age) {
//        name = name;
//        age = age;
//    }

    public Dog(String name, int age) {
        // this.name 就是当前对象的属性name
        this.name = name;
        // this.age 就是当前对象的属性age
        this.age = age;
        System.out.println("this.hashCode = " + this.hashCode());
    }

    public void info() {
        System.out.println("this.hashCode = " + this.hashCode());
        System.out.println(name + "\t" + age + "\t");
    }
}
