package Map_8.a01mymap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangrunze
 */
public class A03_MapDemo3 {
    public static void main(String[] args) {
        // Map集合的第二种遍历方式

        // 1.创建Map集合的对象
        Map<String, String> map = new HashMap<>();

        // 2.添加元素
        // 键：人物的外号
        // 值：人物的名字
        map.put("标枪选手", "马超");
        map.put("人物挂件", "明世隐");
        map.put("御龙骑士", "尹志平");

        /*
         * //3.Map集合的第二种遍历方式
         * //通过键值对对象进行遍历
         * //3.1 通过一个方法获取所有的键值对对象，返回一个Set集合
         * Set<Map.Entry<String, String>> entries = map.entrySet();
         * 
         * //3.2 遍历entries这个集合，去得到里面的每一个键值对对象
         * //entry ---> "御龙骑士","尹志平"
         * for (Map.Entry<String, String> entry : entries) {
         * 
         * //3.3 利用entry调用get方法获取键和值
         * String key = entry.getKey();
         * String value = entry.getValue();
         * System.out.println(key + "=" + value);
         * }
         */

        // 3.Map集合的第二种遍历方式
        // 通过键值对对象进行遍历
        // 3.1 通过一个方法获取所有的键值对对象，返回一个Set集合
        // 3.2 遍历entries这个集合，去得到里面的每一个键值对对象
        // entry ---> "御龙骑士","尹志平"
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // 3.3 利用entry调用get方法获取键和值
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }

    }
}