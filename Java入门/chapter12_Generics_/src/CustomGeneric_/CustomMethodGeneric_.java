package CustomGeneric_;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class CustomMethodGeneric_ {
    public static void main(String[] args) {
        Car car = new Car();
        // 当调用方法时，传入参数，编译器就会确定类型
        car.fly("bmw", 100);
        System.out.println("====");

        // 当调用方法时，传入参数，编译器就会确定类型
        car.fly(300, 100.1);
        System.out.println("====");

        // 测试
        // T = String, R = ArrayList
        // 当调用方法时，传入参数，编译器就会确定类型。所以意思就是只有调用方法实际传入参数的时候
        // 才确定了泛型的类型，所以这里尽管创建对象的时候传入的String和ArrayList
        // 但是真正调用hello方法的时候传入的是ArrayList和Float类型
        Fish<String, ArrayList> fish = new Fish<String, ArrayList>();
        fish.hello(new ArrayList<>(), 11.3f); // 输出ArrayList和float
    }
}


class Car {
    // 普通方法
    public void run() {}

    // 说明
    // 1. <T, R>就是泛型
    // 2. 是提供给fly方法使用的
    // 泛型方法，可以定义在普通类中，也可以定义在泛型类中
    public <T, R> void fly(T t, R r) {
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}

// 泛型类
class Fish<T, R> {
    public void run() {}

    public<U, M> void eat(U u, M m) {}

    // 说明
    // 1. 下面hi方法不是泛型方法
    // 2. 是hi方法使用了类声明的泛型
    public void hi(T t) {}

    // 泛型方法，可以使用类声明的泛型，也可以使用自己声明的泛型
    public <K> void hello(R r, K k) {
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }
}