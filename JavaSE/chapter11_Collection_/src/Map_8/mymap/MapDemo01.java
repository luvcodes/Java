package Map_8.mymap;

import java.util.HashMap;

/**
 * @author ryanw
 */
public class MapDemo01 {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        // V put(K key, V value) 将指定的值与该映射中的指定键相关联
        hashMap.put("itheima001","林青霞");
        hashMap.put("itheima002","张曼玉");
        hashMap.put("itheima003","王祖贤");
        hashMap.put("itheima003","柳岩");

        System.out.println(hashMap);
    }
}
