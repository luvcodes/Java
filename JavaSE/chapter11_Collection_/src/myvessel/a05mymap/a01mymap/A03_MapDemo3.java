package myvessel.a05mymap.a01mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class A03_MapDemo3 {
    public static void main(String[] args) {
        // Map集合的第二种遍历方式 通过键值对的方式

        // 三个课堂练习：
        // 练习一：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用增强for的形式进行遍历
        // 练习二：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用迭代器的形式进行遍历
        // 练习三：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用lambda的形式进行遍历

        Map<String, String> map = new HashMap<>();

        map.put("标枪选手", "马超");
        map.put("人物挂件", "明世隐");
        map.put("御龙骑士", "尹志平");

        // Map集合的遍历方式
        // 通过一个方法获取所有的键值对对象，返回一个Set集合
        // 遍历entries这个集合，去得到里面的每一个键值对对象
        Set<Map.Entry<String, String>> entries = map.entrySet();

        // 增强 for 循环
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        // 迭代器遍历
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 匿名内部类遍历
        entries.forEach(new Consumer<Map.Entry<String, String>>() {
            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                System.out.println(stringStringEntry.getKey() + ":" + stringStringEntry.getValue());
            }
        });

        // lambda表达式遍历
        entries.forEach(stringStringEntry -> {
            System.out.println(stringStringEntry.getKey() + ":" + stringStringEntry.getValue());
        });


    }
}
