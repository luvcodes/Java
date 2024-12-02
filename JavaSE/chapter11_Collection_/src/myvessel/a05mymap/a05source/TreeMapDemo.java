package myvessel.a05mymap.a05source;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

        tm.put(1, "aaa");
        tm.put(2, "bbb");
        tm.put(3, "ccc");
        tm.put(4, "ddd");

        System.out.println(tm);
    }
}
