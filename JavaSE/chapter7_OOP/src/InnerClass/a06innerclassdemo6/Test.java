package InnerClass.a06innerclassdemo6;

/**
 * @author ryanw
 */
public class Test {
    public static void main(String[] args) {
        // 实现接口，编写匿名内部类的代码
        new Swim() {
            @Override
            public void swim() {
                System.out.println("重写了游泳的方法");
            }
        };

        // 继承抽象类，编写匿名内部类代码
        new Animal() {
            @Override
            public void eat() {
                System.out.println("重写了eat方法");
            }
        };


        //在测试类中调用下面的method方法？
        //以前的方式如何调用？
        //要自己写一个子类继承Animal类，再创建子类的对象，传递给method方法
        /*
        Dog d = new Dog();
        method(d);
        */
        //如果Dog类我只要用一次，那么还需要单独定义一个类太麻烦了。

        method(
                new Animal() {
                    @Override
                    public void eat() {
                        System.out.println("狗吃骨头");
                    }
                }
        );
    }


    public static void method(Animal a) {
        // Animal a = 子类对象 多态
        // 编译看左边，运行看右边。编译的时候会先看Animal类中有没有eat方法，运行的时候会执行Dog的具体eat方法。
        a.eat();
    }
}