package myvessel.a05mymap.a02myhashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class A01_HashMapDemo1 {
    public static void main(String[] args) {
        /*
        需求：创建一个HashMap集合，键是学生对象(Student)，值是籍贯(String)。
        存储三个键值对元素，并遍历
        要求：同姓名，同年龄认为是同一个学生

        核心点：
            HashMap的键位置如果存储的是自定义对象，需要重写hashCode和equals方法。
        */

        HashMap<Student, String> map = new HashMap<>();

        map.put(new Student("zhangsan", 23), "江苏");
        map.put(new Student("lisi", 24), "浙江");
        map.put(new Student("wangwu", 25), "福建");
        map.put(new Student("wangwu", 25), "山东");

        System.out.println(map);

        // 遍历集合
        // 方法一: 使用get()方法
        Set<Student> keySet = map.keySet();
        Iterator<Student> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + ":" + map.get(iterator.next()));
        }

        // 方法二: 使用entrySet()方法
        // 迭代器方式遍历
        Set<Map.Entry<Student, String>> entries = map.entrySet();
        Iterator<Map.Entry<Student, String>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Student, String> entry = entryIterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 增强for循环遍历
        Set<Map.Entry<Student, String>> entries1 = map.entrySet();
        for (Map.Entry<Student, String> entry : entries1) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // forEach循环遍历
        Set<Map.Entry<Student, String>> entries2 = map.entrySet();
        entries2.forEach(new Consumer<Map.Entry<Student, String>>() {
            @Override
            public void accept(Map.Entry<Student, String> studentStringEntry) {
                System.out.println(studentStringEntry.getKey() + ":" + studentStringEntry.getValue());
            }
        });

        // lambda表达式遍历
        Set<Map.Entry<Student, String>> entries3 = map.entrySet();
        entries3.forEach(studentStringEntry -> {
            System.out.println(studentStringEntry.getKey() + ":" + studentStringEntry.getValue());
        });
    }
}
