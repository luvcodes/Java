package PhaseOne.Intermediate.CommonClasses_.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethod01 {
    public static void main(String[] args) {


        Integer arr[] = {1,-1, 7, 0, 89};
        /**
         * 1. 可以使用冒泡排序，也可以直接使用Arrays提供的sort方法排序
         * 2. 因为数组是引用类型，所以通过sort排序后，会直接影响到实参 arr
         * 3. sort重载的，也可以通过传入一个接口 Comparator 实现定制排序
         * 4. 调用 定制排序 时，传入两个参数 (1) 排序的数组 arr
         *    (2) 实现了Comparator接口的匿名内部类，要求实现 compare方法
         * 5. 先演示效果，再解释
         * Arrays.sort(arr); // 默认排序方法
         * 定制排序
         * */
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println("====After sorting====");
        System.out.println(Arrays.toString(arr));
    }
}
