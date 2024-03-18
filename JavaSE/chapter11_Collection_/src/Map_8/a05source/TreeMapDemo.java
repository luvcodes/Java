package Map_8.a05source;

import java.util.TreeMap;

/**
 * @author yangrunze
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(1, "aaa");
        tm.put(2, "bbb");
        tm.put(3, "ccc");
        tm.put(4, "ddd");

        System.out.println(tm);

    }
}
