package PhaseOne.Intermediate.Collection_3;

import java.util.ArrayList;

@SuppressWarnings({ "all" })
public class CollectionMethod_2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        // add method: 1 element
        list.add("jack");
        list.add(10);
        list.add(true);
        System.out.println("list = " + list);

        // remove target element
        list.remove(0); // 删除第一个元素
        list.remove(true); // 指定删除某个元素
        System.out.println("list = " + list);

        // contains: 查找元素是否存在
        System.out.println(list.contains("jack"));

        // size: 获取元素个数
        System.out.println(list.size());

        // isEmpty: 判断是否为空
        System.out.println(list.isEmpty());

        // clear: 清空
        // list.clear();
        // System.out.println("list = " + list);

        // addAll: 添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("三国演义");
        list.addAll(list2);
        System.out.println("list = " + list);

        // containsAll: 查找多个元素是否都存在
        System.out.println(list.containsAll(list2));

        // removeAll: 删除多个元素
        list.add("聊斋");
        list.removeAll(list2);
        System.out.println("list = " + list);
    }
}
