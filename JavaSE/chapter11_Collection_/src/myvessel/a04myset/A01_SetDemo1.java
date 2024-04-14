package myvessel.a04myset;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author ryanw
 */
public class A01_SetDemo1 {
    public static void main(String[] args) {
        // 利用Set系列的集合，添加字符串，并使用多种方式遍历
        // 1. 创建一个Set集合的对象
        Set<String> s = new HashSet<>();

        // 2. 添加元素
        // 如果当前元素是第一次添加，那么可以添加成功，返回true
        // 如果当前元素是第二次添加，那么添加失败，返回false
        s.add("张三");
        // false
        System.out.println(s.add("张三"));
        s.add("李四");
        s.add("王五");

        // remove(Object o)：移除元素
        s.remove("张三");
        System.out.println("After removing 张三: " + s);

        // contains(Object o)：检查是否包含某元素
        System.out.println(s.contains("李四"));
        System.out.println(s.containsAll(Arrays.asList("李四", "王五")));

        // isEmpty()：检查集合是否为空
        System.out.println(s.isEmpty());

        // size()：获取集合大小
        System.out.println(s.size());

        // clear()：清空集合
        s.clear();
        System.out.println(s);

        // toArray()：转换为数组
        Object[] array = s.toArray();
        System.out.println(Arrays.toString(array));
        for (Object o : array) {
            System.out.println(o);
        }

        // addAll(Collection<? extends E> c)：添加另一个集合的所有元素
        Set<String> fruits = new HashSet<>();
        fruits.add("苹果");
        fruits.add("香蕉");
        s.addAll(fruits);
        System.out.println("添加水果后的Set: " + s);

        // removeAll(Collection<?> c)：移除存在于另一个集合中的元素
        s.removeAll(fruits);
        System.out.println("After removing new fruits: " + s);

        // retainAll(Collection<?> c)：仅保留存在于另一个集合中的元素
        s.add("Honeydew");
        s.retainAll(fruits);
        System.out.println("After retaining new fruits: " + s);

        // 3.打印集合 无序
        System.out.println(s);

        // 迭代器遍历
        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------------------");

        // 增强for
        for (String string : s) {
            System.out.println(string);
        }
        System.out.println("---------------------------");

        // 匿名内部类
        s.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("---------------------------");

        // Lambda表达式
        s.forEach(str -> System.out.println(str));

        // 不支持普通for循环遍历集合
        /*for (int i = 0; i < s.size(); i++) {
            System.out.println();
        }*/
    }
}
