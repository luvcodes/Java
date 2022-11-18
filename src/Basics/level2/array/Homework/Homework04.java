package Basics.level2.array.Homework;

public class Homework04 {
    // 升序的数组，插入一个元素，依然是升序
    /**
     * 本质数组扩容 + 定位
     * 1. 先确定添加数应该加入到哪个索引
     * 2. 然后扩容
     * */
    public static void main(String[] args) {
        // 定义原数组
        int[] arr = {10, 12, 45, 90};
        int insertNum = 23;
        int index = -1;
        /**
         * 遍历arr数组，如果发现insertNum <= arr[i], 说明i就是要插入的位置
         * 使用index 保留index = i
         * 如果遍历完后，没有发现insertNum <= arr[i]，说明index = arr.length
         * 即: 添加到arr的最后
         * */
        for (int i = 0; i < arr.length; i++) {
            if (insertNum <= arr[i]) {
                index = i;
                break; // 找到位置，立刻退出
            }
        }

        // 通过判断index的值，可以看出是否进入循环了
        if (index == -1) { // 说明没有找到位置
            index = arr.length;
        }

        System.out.println("index = " + index);

        /**
         * 扩容
         * 先创建一个新的数组，大小 arr.length + 1
         * i控制arr2的下标，j用来控制arr的下标
         * */
        int[] arr2 = new int[arr.length + 1];
        // 数组拷贝，并且要跳过index位置
        for (int i = 0, j = 0; i < arr2.length; i++) {
            if (i != index) { // 说明可以把arr的元素拷贝到arr2
                arr2[i] = arr[j];
                j++;
            } else { // i这个唯一就是要插入的数
                arr2[i] = insertNum;
            }
        }

        /**
         * 让arr指向arr2，原来的数组就称为垃圾，被销毁
         * */
        arr = arr2;

        /**
         * 输出
         * */
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
