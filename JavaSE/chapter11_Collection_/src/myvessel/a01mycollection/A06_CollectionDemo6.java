package myvessel.a01mycollection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ryanw
 */
public class A06_CollectionDemo6 {
    public static void main(String[] args) {
        // 1. 创建集合并添加元素
        Collection<String> coll = new ArrayList<>();
        coll.add("zhangsan");
        coll.add("lisi");
        coll.add("wangwu");
        // 2. 利用增强for进行遍历
        // 注意点: s其实就是一个第三方变量，在循环的过程中依次表示集合中的每一个数据
        // 每次迭代会将集合中的一个元素的值赋给变量 s
        // 这个操作实际上只是改变了 s 这个局部变量的值，并不影响原集合 coll 中的元素。
        for (String s : coll) {
            s = "qqq";
            System.out.println(s);
        }

        System.out.println(coll);
        for (String s : coll) {
            System.out.println(s);
        }
    }
}
