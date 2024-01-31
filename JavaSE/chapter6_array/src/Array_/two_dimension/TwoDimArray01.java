package Array_.two_dimension;

public class TwoDimArray01 {
    public static void main(String[] args) {
        /*
         * 0 0 0 0 0 0
         * 0 0 1 0 0 0
         * 0 2 0 3 0 0
         * 0 0 0 0 0 0
         */
        // 什么是二维数组:
        // 1. 从定义形式上看 int[][]
        // 2. 可以这样理解，原来的一维数组的每个元素是一维数组。就构成了二维数组
        int[][] arr = {{0,0,0,0,0,0}, {0,0,1,0,0,0},
                {0,2,0,3,0,0}, {0,0,0,0,0,0}};

        // 关键概念
        // 1. 二维数组的元素个数
        System.out.println("二维数组的元素个数: " + arr.length);
        // 2. 二维数组的每个元素是一维数组，所以如果需要得到每个一维数组的值，还需要再次遍历
        // 3. 如果要访问第i+1个一维数组的第j+1个值 arr[i][j], 比如要访问3，
        // 它是第3个一维数组的第4个值，实际是arr[3-1][4-1]
        System.out.println("第3个一维数组的第4个值 = " + arr[2][3]);

        // 输出
        // 外层遍历二维数组的每个元素
        // 内层遍历二维数组的每个元素(数组)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println(); // 换行
        }
    }
}
