package myvessel.a04myset;


import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @author ryanw
 */
public class A04_TreeSetDemo1 {
    public static void main(String[] args) {
        // 需求：利用TreeSet存储整数并进行排序
        //1.创建TreeSet集合对象
        TreeSet<Integer> ts = new TreeSet<>();

        //2.添加元素
        ts.add(4);
        ts.add(5);
        ts.add(1);
        ts.add(3);
        ts.add(2);

        //3.打印集合
        //System.out.println(ts);

        //4.遍历集合（三种遍历）
        //迭代器
        Iterator<Integer> it = ts.iterator();
        while (it.hasNext()) {
            int i = it.next();
            System.out.println(i);
        }
        System.out.println("--------------------------");

        //增强for
        for (int t : ts) {
            System.out.println(t);
        }
        System.out.println("--------------------------");

        // 匿名内部类
        ts.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //lambda
        ts.forEach(i -> System.out.println(i));
    }
}
