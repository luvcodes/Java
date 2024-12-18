package Map_8.a01mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author yangrunze
 */
public class A02_MapDemo2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("尹志平", "小龙女");
        map.put("郭靖", "穆念慈");
        map.put("欧阳克", "黄蓉");

        // 3. 通过键找值
        // 3.1 获取所有的键，把这些键放到一个单列集合当中
        Set<String> keys = map.keySet();
        // 3.2 遍历单列集合，得到每一个键

        // 增强for遍历
        for (String key : keys) {
            //3.3 利用map集合中的键获取对应的值 get
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        // 迭代器遍历
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(key);
            System.out.println("key: " + key + ", value: " + value);
        }

        // 匿名内部类遍历
        map.keySet().forEach(new Consumer<String>() {
            @Override
            public void accept(String key) {
                String value = map.get(key);
                System.out.println("key: " + key + ", value: " + value);
            }
        });

        // Lambda表达式遍历
        keys.forEach(key -> {
            String value = map.get(key);
            System.out.println("key: " + key + ", value: " + value);
        });
    }
}
