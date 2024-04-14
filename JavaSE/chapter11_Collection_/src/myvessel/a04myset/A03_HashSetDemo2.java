package myvessel.a04myset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author yangrunze
 */
public class A03_HashSetDemo2 {
    public static void main(String[] args) {
        /* 需求：创建一个存储学生对象的集合，存储多个学生对象。
            使用程序实现在控制台遍历该集合。
            要求：学生对象的成员变量值相同，我们就认为是同一个对象
            String   Integer 如果是这两种类型的，Java内部已经定义好了hashcode、equals方法重写，所以默认就不能重复添加相同值。
        */

        // 1. 创建三个学生对象
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);
        Student s4 = new Student("zhangsan", 23);

        // 2. 创建集合用来添加学生
        HashSet<Student> hs = new HashSet<>();

        // 3. 添加元素 这样输出的是true/false
        System.out.println(hs.add(s1));
        System.out.println(hs.add(s2));
        System.out.println(hs.add(s3));
        System.out.println(hs.add(s4));

        // 4. 打印集合
        System.out.println(hs);
        System.out.println("---------------------------");

        // 三种方式遍历集合
        // 迭代器遍历
        Iterator iterator = hs.iterator();
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            System.out.println(student);
        }
        System.out.println("---------------------------");

        // 增强for遍历
        for (Student student : hs) {
            System.out.println(student);
        }
        System.out.println("---------------------------");

        // 内部类遍历
        hs.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
        System.out.println("---------------------------");

        // lambda表达式遍历
        hs.forEach(student -> System.out.println(student));
    }
}
