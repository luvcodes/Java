package Basics.level2.array.two_dimension;

public class TwoDimArray03 {
    public static void main(String[] args) {
        // 二维数组的第三种使用方式，动态初始化-列数不确定

        // {{1}, {2,2}, {3,3,3}}
        // 3个一维数组，但是每个一维数组的元素是不一样的, 一共有3个一维数组
        // 但是每个一维数组还没有开数据控件。
        int[][] arr = new int[3][];

        // 遍历arr的每个一维数组
        for (int i = 0; i < arr.length; i++) {
            // 给每个一维数组开空间
            // 如果没有给一维数组new，那么arr[i]就是null
            arr[i] = new int[i + 1];
            // 遍历一维数组并给一维数组的每个元素赋值
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1; // 赋值
            }
        }

        // 遍历arr
        for (int i = 0; i < arr.length; i++) {
            // 输出arr的每个一维数组
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class A {
    public static void main(String[] args) {
        // 二维数组的第四种使用方式: 静态初始化
        /**
         * 1. 定义了一个二维数组arr
         * 2. arr有三个元素(每个元素都是一维数组)
         * 3. 第一个一维数组有3个元素，第二个一维数组有3个元素，第三个一维数组有1个元素
         * */
        int[][] arr = {{1,1,1}, {8,8,9}, {100}};
    }
}
