package myvessel.a04myset;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Consumer;

/**
 * @author yangrunze
 */
public class A04_LinkedHashSetDemo {
    public static void main(String[] args) {
        //1.创建4个学生对象
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);
        Student s4 = new Student("zhangsan", 23);

        //2.创建集合的对象
        LinkedHashSet<Student> lhs = new LinkedHashSet<>();

        //3.添加元素
        System.out.println(lhs.add(s3));
        System.out.println(lhs.add(s2));
        System.out.println(lhs.add(s1));
        System.out.println(lhs.add(s4));

        //4.打印集合
        // 添加顺序就是输出顺序
        System.out.println(lhs);

        // 多种方式遍历LinkedHashSet
        // 迭代器遍历
        Iterator<Student> iterator = lhs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 增强for遍历
        for (Student student : lhs) {
            System.out.println(student);
        }

        // 匿名内部类遍历
        lhs.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });

        // lambda表达式遍历
        lhs.forEach(student -> System.out.println(student));
    }
}
