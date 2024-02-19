package MethodRef_;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 1. 使用情景: 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 * 2. 方法引用: 本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例
 * 3. 使用格式: 类(或对象) :: 方法名
 * 4. 具体分为如下的三种情况:
 *    对象 :: 非静态方法
 *    类 :: 静态方法
 *    类 :: 非静态方法
 * 5. 方法引用使用的要求: 要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 * 形参列表和返回值类型相同
 *
 * @author ryanw
 * */
public class MethodReference {
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


    /**
     * 情况2: 类 :: 静态方法
     * */

    @Test
    public void test3() {
        Comparator<Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator.compare(12, 21));

        System.out.println("*******************");
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(12, 3));
    }


    // Function中的R apply(T t)
    // Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double, Long> func1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println("********************");
        Function<Double, Long> func2 = d -> Math.round(d);
        System.out.println(func2.apply(12.3));
        System.out.println("********************");
        Function<Double, Long> func3 = Math::round;
        System.out.println(func3.apply(12.6));
    }

     /**
      * 情况三: 类 :: 实例方法
      * Comparator中的int compare(T t1, T t2)
      * String中的int t1.compareTo(t2)
      */
    @Test
    public void test5() {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("abc", "abd"));
        System.out.println("****************");
        Comparator<String> comparator1 = String :: compareTo;
        // -9 c减m的ascii码得到的
        System.out.println(comparator1.compare("abc", "abm"));
    }

    // BiPredicate中的boolean test(T t1, T t2);
    // String中的boolean t1.equals(t2)
    @Test
    public void test6() {
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
        System.out.println(predicate.test("abc", "abc"));

        System.out.println("****************");
        BiPredicate<String, String> predicate1 = String :: equals;
        System.out.println(predicate1.test("abc", "abd"));
    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
        Employee mark = new Employee(10, "mark", 23, 6000);
        Function<Employee, String> function = emp -> emp.getName();
        System.out.println(function.apply(mark));
        System.out.println("*****************");
        Function<Employee, String> function1 = Employee::getName;
        System.out.println(function1.apply(mark));
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
