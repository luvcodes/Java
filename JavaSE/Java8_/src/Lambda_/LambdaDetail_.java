package Lambda_;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用: 分为6种情况介绍
 * 总结:
 *  -> 左边: lambda形参列表的参数类型可以省略；如果Lambda形参列表只有一个参数，其一对()也可以省略
 *                                      如果lambda形参列表没有参数或者有一个以上参数，一对()不可以省略
 *  -> 右边: lambda体应该使用一对{}包裹; 如果lambda体只有一条执行语句 (可能是return语句)，可以省略这一对{}和return关键字
 * </p>
 * Lambda表达式的本质: 作为接口的实例
 * </p>
 * 函数式接口: 只有一个抽象方法的接口，称为函数式接口。我们可以在一个接口上使用@FunctionalInterface注解，
 * 这样做可以检查它是否是一个函数式接口。
 * </p>
 * 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写
 * @author ryanw
 */

public class LambdaDetail_ {
    // 语法格式一: 无参，无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love beijing");
            }
        };
        r1.run();

        System.out.println("******************");
        Runnable r2 = () -> System.out.println("I love peking");
        r2.run();
    }

//    // 语法格式二: Lambda需要一个参数，但是没有返回值
//    @Test
//    public void test2() {
//        Comsumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        consumer.accept("谎言和誓言的区别是什么? ");
//
//        System.out.println("******************");
//        Consumer<String> con1 = (String s) -> {
//            System.out.println(s);
//        };
//        con1.accept("一个是听的人当真了，一个是说的人当真了");
//    }
//
//    // 语法格式三: 数据类型可以省略，因为可由编译器推断得出，称为”类型推断“
//    @Test
//    public void test3() {
//        Comsumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        consumer.accept("谎言和誓言的区别是什么? ");
//
//        System.out.println("******************");
//        Consumer<String> con1 = (s) -> {
//            System.out.println(s);
//        };
//        con1.accept("一个是听的人当真了，一个是说的人当真了");
//    }

    // 语法格式四: Lambda如果只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4() {
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("**************************");
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("一个是听的人当真了，一个是说的人当真了");
    }

    // 语法格式五: Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,21));
        System.out.println("*************************");
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12,6));
    }

    // 语法格式六: 当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test7() {
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12,21));

        System.out.println("*************************");
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12,6));
    }
}