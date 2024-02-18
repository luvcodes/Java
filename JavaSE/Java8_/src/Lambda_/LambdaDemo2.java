package Lambda_;

/**
 * @author ryanw
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        /**
         * Lambda表达式注意点:
         * 1. Lambda表达式可以简化匿名内部类的书写
         * 2. Lambda表达式只能简化函数式接口的匿名内部类的写法
         * 3. 函数式接口: 有且只有一个抽象方法的接口叫做函数式接口，接口上方可以加@FunctionalInterface注解
         * */

        // 1. 匿名内部类
//        method(new Swim() {
//            @Override
//            public void swimming() {
//                System.out.println("正在游泳");
//            }
//        });

        // 2. 使用lambda表达式
        method(() -> {
            System.out.println("正在游泳~~~");
        });

    }

    public static void method(Swim s) {
        s.swimming();
    }
}

@FunctionalInterface
interface Swim {
    void swimming();
}
