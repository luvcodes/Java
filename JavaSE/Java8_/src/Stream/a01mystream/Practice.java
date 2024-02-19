package Stream.a01mystream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author ryanw
 */
public class Practice {
    public static void main(String[] args) {
        // 1. 单列集合，Set和List
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a","b","c","d","e");

        list.stream().forEach(s -> System.out.println(s));
        System.out.println();

        // 2. 双列集合 无法直接使用stream流
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("aaa",111);
        hm.put("bbb",222);
        hm.put("ccc",333);
        hm.put("ddd",444);

        hm.keySet().stream().forEach(s -> System.out.println(s));
        hm.entrySet().stream().forEach(s -> System.out.println(s));
        System.out.println();

        // 3. Arrays工具类中的静态方法
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] arr2 = {"a", "b", "c"};
        Arrays.stream(arr1).forEach(s -> System.out.print(s + "\t"));
        System.out.println("============================");
        Arrays.stream(arr2).forEach(s -> System.out.print(s + "\t"));
        System.out.println("============================");


        // 4. 一堆零散数据
        Stream.of(1,2,3,4,5).forEach(s -> System.out.print(s));
        System.out.println("============================");
        Stream.of("a","b","c","d","e").forEach(s -> System.out.println(s));
        System.out.println("============================");
    }
}
