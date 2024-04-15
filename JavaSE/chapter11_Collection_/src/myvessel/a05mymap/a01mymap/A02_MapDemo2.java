package myvessel.a05mymap.a01mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class A02_MapDemo2 {
    public static void main(String[] args) {
        // Map集合的第一种遍历方式 通过键找值
        // 三个课堂练习：
        // 练习一：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用增强for的形式进行遍历
        // 练习二：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用迭代器的形式进行遍历
        // 练习三：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用lambda表达式的形式进行遍历

        // 1. 创建 Map 集合的对象
        HashMap<String, String> map = new HashMap<>();

        // 2. 添加元素
        map.put("尹志平", "小龙女");
        map.put("郭靖", "穆念慈");
        map.put("欧阳克", "黄蓉");

        // 练习一 增强 for 循环遍历
        // 3. 通过键找值
        // 3.1 获取所有的健，把这些键放到一个单列集合当中
        Set<String> keys1 = map.keySet();
        // 3.2 遍历单列结合，得到每一个键
        for (String key : keys1) {
            // 3.3 利用map集合中的键获取对应的值  get
            System.out.println(key + ":" + map.get(key));
        }

        // 练习二 iterator迭代器遍历
        Set<String> keys2 = map.keySet();
        Iterator<String> iterator = keys2.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + map.get(key));
        }

        // 练习三 匿名内部类遍历
        Set<String> keys3 = map.keySet();
        keys3.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + ":" + map.get(s));
            }
        });

        // 联系四 lambda 表达式遍历
        Set<String> keys4 = map.keySet();
        keys4.forEach(s -> System.out.println(s + ":" + map.get(s)));
    }
}
