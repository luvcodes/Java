package Map_8.mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ryanw
 */
public class MapDemo02 {
    public static void main(String[] args) {
        // Map集合的第一种遍历方式

        //三个课堂练习：
        //练习一：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用增强for的形式进行遍历
        //练习二：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用迭代器的形式进行遍历
        //练习三：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用lambda表达式的形式进行遍历

        HashMap<String, String> map = new HashMap<>();
        map.put("尹志平","小龙女");
        map.put("郭靖","穆念慈");
        map.put("欧阳克","黄蓉");

        //3.通过键找值
        //3.1获取所有的键，把这些键放到一个单列集合当中
        Set<String> keys = map.keySet();
        System.out.println("====增强for====");
        for (String key : keys) {
            //3.3 利用map集合中的键获取对应的值  get
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("====迭代器遍历====");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(key);
        }

        System.out.println("====Lambda表达式遍历====");
        keys.forEach(key -> {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        });

    }
}
