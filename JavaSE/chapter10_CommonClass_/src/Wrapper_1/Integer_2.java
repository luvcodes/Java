package Wrapper_1;

/**
 * @author ryanw
 * */
@SuppressWarnings("all")
public class Integer_2 {
    public static void main(String[] args) {
        // int <-> Integer 的装箱和拆箱

        // 手动装箱 int -> Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        // 手动拆箱 Integer -> int
        int i = integer.intValue();

        // jdk5以后，就可以自动装箱和拆箱了
        // 自动装箱 int -> Integer
        int n2 = 200;
        Integer integer2 = n2; // 底层使用的是 Integer.valueOf(n2)

        // 自动拆箱 Integer -> int
        int n3 = integer2; // 底层使用的是intValue() 方法
    }

    /**
     * 展示Integer的实例化方式
     * */
    public static void aboutInteger() {
        // 1. 通过new关键字来进行实例化
        Integer first = new Integer(100);

        // 2. 通过valueOf方法进行实例化
        // 由于 valueOf 方法在内部缓存了 -128 到 127 之间的所有可能值，你可以省略参数，直接使用
        Integer second = Integer.valueOf(200);

        // 3. 使用字符串构造函数
        String third = "123";
        String thirdInt = String.valueOf(third);
    }
}
