package arrays_3;

import java.util.Arrays;
import java.util.List;

/**
 * @author ryanw
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 123, 567};
        // binarySearch 通过二分搜索法进行查找，要求必须排好
        // 1. binarySearch二分查找，要求数组有序
        // 2. 如果数组中不存在该元素，就返回 return -(low + 1); // key not found
        //    比如查找92，那就是 -(3 + 1)
        int index = Arrays.binarySearch(arr, 123);
        System.out.println("index = " + index);

        // copyOf 数组元素的复制
        /**
         * 1. 从arr数组中，拷贝arr.length个元素到newArr数组中
         * 2. 如果拷贝的长度 > arr.length 就在新数组的后面 增加null
         * 3. 如果拷贝长度 < 0, 就抛出异常NegativeArraySizeException
         * */
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println("Copy executed complete");
        System.out.println(Arrays.toString(newArr));

        // fill 数组元素的填充
        Integer[] num = new Integer[]{9, 3, 2};
        Arrays.fill(num, 99);
        System.out.println("==num数组填充后==");
        System.out.println(Arrays.toString(num));

        // equals 比较两个数组元素内容是否完全一致
        Integer[] arr2 = {1, 2, 90, 123, 567};
        // 1. 如果arr和arr2数组的元素一样，则方法true;
        // 2. 如果不是完全一样，就返回 false;
        boolean equals = Arrays.equals(arr, arr2);
        System.out.println("equals = " + equals);

        // asList 将一组值，转换成list
        // 1. asList方法，会将(2,3,4,5,6,1)数据转成一个List集合
        // 2. 返回的 asList 编译类型 List(接口)
        // 3. asList 运行类型 java.util.Arrays#ArrayList，是Arrays类的
        //    静态内部类 private static class ArrayList<E> extends AbstractList<E> implements RandomAccess, java.io.Serializable
        List asList = Arrays.asList(2, 3, 4, 5, 6, 1);
        System.out.println("asList = " + asList);
        System.out.println("asList compile type: " + asList.getClass());
    }
}
