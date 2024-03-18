package a07mycollections;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo1 {
    public static void main(String[] args) {
      /*
        public static <T> boolean addAll(Collection<T> c, T... elements)        批量添加元素
        public static void shuffle(List<?> list)                                打乱List集合元素的顺序
     */



        //addAll  批量添加元素
        //1.创建集合对象
        ArrayList<String> list = new ArrayList<>();
        //2.批量添加元素
        Collections.addAll(list,"abc","bcd","qwer","df","asdf","zxcv","1234","qwer");
        //3.打印集合
        System.out.println(list);

        //shuffle 打乱
        Collections.shuffle(list);

        System.out.println(list);

    }
}
