package MethodRef_;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * 方法引用的使用
 * 1. 使用情景: 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 * */
public class MethodRef_ {
    /**
     * 情况一: 对象 :: 实例方法
     * Consumer中的void accept(T t)
     * PrintStream中的void println(T t)
     * */
    @Test
    public void test1() {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("beijing");
    }
}
