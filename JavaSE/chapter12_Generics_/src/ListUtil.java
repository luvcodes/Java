import java.util.ArrayList;

/**
 * @author ryanw
 */
public class ListUtil {
    private ListUtil() {
    }

    // 类中定义一个静态方法addAll，用来添加多个集合的元素。
    /*
     * 参数一: 集合
     * 参数二到最后：要添加的元素
     */
    public static <E> void addAll(ArrayList<E> list, E e1, E e2, E e3, E e4) {
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
    }

    /*
     * public static <E> void addAll2(ArrayList<E> list, E...e){
     * for (E element : e) {
     * list.add(element);
     * }
     * }
     */

    public void show() {
        System.out.println("尼古拉斯·纯情·天真·暖男·阿玮");
    }
}
