package myvessel.a01mycollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author ryanw
 */
public class A05_CollectionDemo5 {
    public static void main(String[] args) {
       /*
        迭代器的细节注意点：
            1.报错NoSuchElementException
            2.迭代器遍历完毕，指针不会复位
            3.循环中只能用一次next方法
            4.迭代器遍历时，不能用集合的方法进行增加或者删除
                暂时当做一个结论先行记忆，在今天我们会讲解源码详细的再来分析。
                如果我实在要删除：那么可以用迭代器提供的remove方法进行删除。
                如果我要添加，暂时没有办法。
        */
        // 1. 创建集合并添加元素
        Collection<String> collection = new ArrayList<String>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        collection.add("D");

        // 2. 获取迭代器对象
        // 迭代器就好比是一个箭头，默认指向集合的0索引处
        Iterator<String> iterator = collection.iterator();
        // 3. 利用循环不断的去获取集合中的每一个元素
        while (iterator.hasNext()) {
            // 4. next方法的两件事情：获取元素,并移动指针
            String str = iterator.next();
            if ("B".equals(str)) {
                iterator.remove();
            }
        }
        System.out.println(collection);
    }
}
