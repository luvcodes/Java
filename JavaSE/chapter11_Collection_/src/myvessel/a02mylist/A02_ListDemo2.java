package myvessel.a02mylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryanw
 * 当使用 ArrayList 的 add 方法添加元素时，这个元素的类型取决于你传递给 add 方法的参数类型。
 * 例如，如果有一个 ArrayList<Integer> 类型的列表，你可以添加 int 类型的值，也可以添加 Integer 类型的值。
 * Java 会自动装箱基本数据类型 int 为对应的包装类 Integer。
 */
public class A02_ListDemo2 {
    public static void main(String[] args) {
        // List系列集合中的两个删除的方法
        // 1. 直接删除元素
        // 2. 通过索引进行删除

        /**
         * 当使用 ArrayList 的 add 方法添加元素时，这个元素的类型取决于你传递给 add 方法的参数类型。
         * 例如，如果有一个 ArrayList<Integer> 类型的列表，你可以添加 int 类型的值，也可以添加 Integer 类型的值。
         * Java 会自动装箱基本数据类型 int 为对应的包装类 Integer。
         * */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 2. 删除元素
        // 请问：此时删除的是1这个元素，还是1索引上的元素？删除的是1索引上的元素
        // 因为在调用方法的时候，如果方法出现了重载现象就优先调用实参跟形参类型一致的那个方法。
        // list.remove(1);

        // 手动装箱，手动把基本数据类型的1，变成Integer类型
        Integer i = Integer.valueOf(1);
        // 这样删除的就是1这个元素
        list.remove(i);

        System.out.println(list);
    }
}
