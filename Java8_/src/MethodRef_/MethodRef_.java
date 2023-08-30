package MethodRef_;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 1. 使用情景: 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 * 2. 方法引用: 本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 * 方法引用，也是函数式接口的实例
 * 3. 使用格式:     类(或对象) :: 方法名
 * 4. 具体分为如下的三种情况:
 *    对象 :: 非静态方法
 *    类 :: 静态方法
 *    类 :: 非静态方法
 * 5. 方法引用使用的要求: 要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表
 * 和返回值类型相同
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
        System.out.println("************");
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        consumer1.accept("beijing");
    }

    // Supplier中的T get()
    // Employee中的String getName()
    @Test
    public void test2() {
        Employee emp = new Employee(1001, "Tom", 23, 5600);
        Supplier<String> supplier = () -> emp.getName();
        supplier.get();

        System.out.println("*************");
        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2);
    }
}

class Employee {
    private int id;
    private String name;
    private int age;
    private int salary;

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
