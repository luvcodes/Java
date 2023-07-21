package PhaseOne.Intermediate.Collection_3;

import java.util.ArrayList;

public class ArrayListSource_2 {
    public static void main(String[] args) {
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
