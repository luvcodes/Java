package Map_8.a04mytreemap;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author yangrunze
 */
public class A01_TreeMapDemo1 {
    public static void main(String[] args) {
        /*
           TreeMap集合：基本应用
            需求1：
                键：整数表示id
	            值：字符串表示商品名称
	            要求1：按照id的升序排列
	            要求2：按照id的降序排列
         */

        //1.创建集合对象
        //Integer Double 默认情况下都是按照升序排列的
        //String 按照字母再ASCII码表中对应的数字升序进行排列 abcdefg...
        // TreeMap<Integer, String> tm = new TreeMap<>();
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1:当前要添加的元素
                //o2：表示已经在红黑树中存在的元素
                // 降序
                return o2 - o1;
            }
        });

        //2.添加元素
        tm.put(5, "可恰可乐");
        tm.put(4, "雷碧");
        tm.put(3, "九个核桃");
        tm.put(2, "康帅傅");
        tm.put(1, "粤利粤");

        //3.打印集合
        System.out.println(tm);
    }
}
