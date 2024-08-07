package InnerClass.AnonymousInnerClass;

/**
 * 匿名内部类的使用
 *
 * @author ryanw
 * */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {
    private int n1 = 10;
    public void method() {
        /**
         * 基于接口的匿名内部类
         * 1. 需求: 想使用IA接口, 并创建对象
         * 2. 传统方式，是写一个类，实现该接口，并创建对象
         * 3. 现在需求是Tiger类只是使用一次，后面再不使用
         * 4. 使用匿名内部类来简化开发
         * 5. Tiger的运行类型？接口类型
         * 6. tiger的运行类型？匿名内部类 XXXX => Outer04$1
         * */

        /**
         * 看底层 会分配 类名 Outer04$1
         * class XXXX implements IA {
         * @Override
         * public void cry() {
         *     System.out.println("Tiger cry");
         * }
         * }
         * */
        // 7. jdk底层在创建匿名内部类 Outer04$1，立即马上就创建了Outer04$1实例，并且把地址
        // 返回给tiger
        // 8. 匿名内部类使用一次，就不能再使用
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("Tiger cry");
            }
        };
        System.out.println("Tiger operate type = " + tiger.getClass());
        tiger.cry();

        // 匿名内部类
        // 1. father编译类型 Father
        // 2. father运行类型 Outer04$2
        // 3.
        // 4. 同时也直接返回了 匿名内部类 Outer04$2的对象
        // 5. 注意("jack") 参数列表会传输给 构造器
        Father father = new Father("jack") {
            @Override
            public void test() {
                System.out.println("Anonymous inner class override practice_.test() method");
            }
        };
        System.out.println("father object operating type: " + father.getClass());
        father.test();

        // 基于抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("Animal eat");
            }
        };

    }
}

interface IA {
    public void cry();
}
//class Tiger implements IA {
//    @Override
//    public void cry() {
//        System.out.println("Tiger cry");
//    }
//}
//class Dog implements IA {
//    @Override
//    public void cry() {
//        System.out.println("Dog cry");
//    }
//}
class Father {
    public Father(String name) {}

    public void test() {}
}

abstract class Animal {
    abstract void eat();
}