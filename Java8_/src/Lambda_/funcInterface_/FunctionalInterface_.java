package Lambda_.funcInterface_;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

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
//        happyTime(500, new Consumer<Double>() {
//            @Override
//            public void accept(Double aDouble) {
//                System.out.println("矿泉水价格为: " + aDouble);
//            }
//        });

        System.out.println("**********************");
        happyTime(400, money -> System.out.println("矿泉水价格为: " + money));
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}
