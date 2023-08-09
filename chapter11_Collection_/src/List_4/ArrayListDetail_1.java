package List_4;

import java.util.ArrayList;

public class ArrayListDetail_1 {
    public static void main(String[] args) {
        /**
         * 1. ArrayList可以加入null，并且多个
         * 2. ArrayList是由数组来实现数据存储的
         * 3. ArrayList基本等于Vector，没有synchronized修饰，线程不安全
         */
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        System.out.println(arrayList);
        arrayList.add(null);
        arrayList.add("jack");
        System.out.println(arrayList);
    }
}
