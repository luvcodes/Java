package Basics.level2.array.one_dimension.array_basic_1;

public class ArrayExercise02 {
    public static void main(String[] args) {
        // 请求出一个数组int[]的最大值{4,-1,9,10,23}并得到对应的下标

        // 1. 定义一个int数组
        // 2. 假定max = arr[0]是最大值，maxIndex = 0
        // 3. 从下标1开始遍历数组，如果max < 当前元素，说明max不是真正的最大值，因此max = 当前元素，maxIndex = 当前元素下标
        // 4. 遍历数组以后，max就是最大值，maxIndex是最大值下标
        int[] arr = {4, -1, 9, 10, 23};
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("Max: " + max + ", maxIndex: " + maxIndex);
    }
}
