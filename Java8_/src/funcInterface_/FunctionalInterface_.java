package funcInterface_;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterface_ {
    /**
     * java内置的4大核心函数式接口
     * 消费型接口 Consumer<T> void accept(T t)
     * 供给型接口 Supplier<T> T get()
     * 函数型接口 Function<T, R> R apply(T t)
     * 断定型接口 Predicate<T> boolean test(T t)
     * */

    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("矿泉水价格为: " + aDouble);
            }
        });

        System.out.println("**********************");
        happyTime(400, money -> System.out.println("矿泉水价格为: " + money));
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("beijing");
        list.add("najing");
        list.add("tianjin");
        List<String> filterStr = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("jing");
            }
        });

        System.out.println(filterStr);


        System.out.println("******************************");
        // Lambda表达式
        List<String> filterStrs1 = filterString(list, s -> s.contains("jing"));
        System.out.println(filterStrs1);
    }

    /**
     * 根据给定的规则，过滤集合中的字符创。此规则由Predicate的方法决定
     * */
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }

        return filterList;
    }
}
