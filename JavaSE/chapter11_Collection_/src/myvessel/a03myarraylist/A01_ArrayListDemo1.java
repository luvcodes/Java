package myvessel.a03myarraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author ryanw
 */
public class A01_ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        // 1. 迭代器遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }

        // 2. 增强for循环遍历
        for (String s : list) {
            System.out.println(s);
        }

        // 3. lambda表达式循环遍历
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);

        // 4. 普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
