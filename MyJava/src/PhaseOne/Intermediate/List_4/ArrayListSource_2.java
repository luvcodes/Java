package PhaseOne.Intermediate.List_4;

import java.util.ArrayList;

public class ArrayListSource_2 {
    public static void main(String[] args) {
        /**
         * 1. ArrayList中维护了一个Object类型的数组elementData
         * 2. 当创建ArrayList对象时，如果使用的是无参构造器，则出事elementData容量为0，第一次添加，则扩容elementData为10，如需要
         *    再次扩容，则扩容elementData为1.5倍。
         * 3. 如果使用的是指定大小的构造器，则初始elementData容量为指定大小，如果需要扩容，则直接扩容elementData为1.5倍。
         */

        // 使用无参构造器创建ArrayList对象
        // ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        // 使用for给list添加11-15数据
        for (int i = 1; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
        System.out.println(list);
    }
}
