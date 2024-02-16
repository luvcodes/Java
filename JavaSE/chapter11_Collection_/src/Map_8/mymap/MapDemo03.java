package Map_8.mymap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ryanw
 */
public class MapDemo03 {
    public static void main(String[] args) {
        //Map集合的第二种遍历方式

        //三个课堂练习
        //练习一：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用增强for的形式进行遍历
        //练习二：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用迭代器的形式进行遍历
        //练习三：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用lambda的形式进行遍历

        // 1.创建Map集合的对象
        Map<String, String> map = new HashMap<>();

        // 2.添加元素
        map.put("标枪选手", "马超");
        map.put("人物挂件", "明世隐");
        map.put("御龙骑士", "尹志平");

        // 3.通过键找值
        // 3.1获取所有的键，把这些键放到一个单列集合当中
        Set<String> keys = map.keySet();
        // 3.2遍历单列集合，得到每一个键
        for (String key : keys) {
            // System.out.println(key);
            // 3.3 利用map集合中的键获取对应的值  get
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        // 3.Map集合的第二种遍历方式
        // 通过键值对对象进行遍历
        // 3.1 通过一个方法获取所有的键值对对象，返回一个Set集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        // 3.2 遍历entries这个集合，去得到里面的每一个键值对对象
        // entry  --->  "御龙骑士","尹志平"
        for (Map.Entry<String, String> entry : entries) {
            // 3.3 利用entry调用get方法获取键和值
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }
}
