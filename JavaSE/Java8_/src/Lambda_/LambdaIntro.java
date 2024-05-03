package Lambda_;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 * @author ryanw
 * */
@SuppressWarnings("all")
public class LambdaIntro {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love peking");
            }
        };
        r1.run();
        System.out.println("******************");
        Runnable r2 = () -> System.out.println("I love beijing");
        /**
         * 这里即使上面的Lambda表达式没有定义函数名，也可以知道调用run方法是没问题的。
         * 就是因为在Java中，Lambda表达式是一种简洁地表示实例的一个单一方法接口（即只有一个抽象方法的接口）的方式。这种接口被称为“函数式接口”。
         * Runnable就是一个函数式接口，因为它只有一个抽象方法：run()。当您用Lambda表达式来实现这样的接口时，Java编译器能够自动推断您意图实现的是哪一个方法。
         * */
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12,21);
        System.out.println(compare1);
        System.out.println("******************");

        // Lambda表达式写法
        /**
         * 这里使用Integer来调用compare方法的原因是Integer.compare(o1, o2)是一个静态方法，
         * 它定义在Integer类中。它的作用是比较两个int值。由于这是Integer类的静态方法，所以我们使用类名Integer来调用它，
         * 而不是一个特定的Integer对象。
         * </p>
         * 同理，如果定义的Comparator的泛型是Double，应该使用Double.compare(o1, o2)，
         * 因为这是Double类中定义的静态方法，用于比较两个double值。
         * */
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(32,21);
        System.out.println(compare2);
        System.out.println("******************");

        // 方法引用
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com2.compare(32,21);
        System.out.println(compare2);
    }
}
