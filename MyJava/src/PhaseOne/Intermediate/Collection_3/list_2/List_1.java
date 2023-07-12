package PhaseOne.Intermediate.Collection_3.list_2;

import java.util.ArrayList;
import java.util.List;

public class List_1 {
    public static void main(String[] args) {
        @SuppressWarnings({"all"})
        //1. List集合类中元素有序(即添加顺序和取出顺序一致)、且可重复 [案例]
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");
        list.add("tom");
        System.out.println("list=" + list);
        for (Object i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        //2. List集合中的每个元素都有其对应的顺序索引，即支持索引
        //   索引是从0开始的
        System.out.println(list.get(3));//hsp
    }
}
