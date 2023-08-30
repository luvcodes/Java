package Lambda_;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * Lambda表达是的使用举例
 * */

public class LambdaIntro_ {
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

        Runnable r2 = () -> System.out.println("I love peking");

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
