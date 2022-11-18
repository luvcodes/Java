package Basics.level2.array.two_dimension;

public class YangHui {
    public static void main(String[] args) {
        /**
         * 规律:
         * 第一行有1个元素，第n行有n个元素
         * 每一行的第一个元素和最后一个元素都是1
         * 从第三行开始，对于非第一个元素和最后一个元素的元素的值，arr[i][j]
         * arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
         * */
        int[][] yangHui = new int[10][];
        // 遍历yangHui的每个元素
        for (int i = 0; i < yangHui.length; i++) {
            // 给每个一维数组开空间
            yangHui[i] = new int[i+1];
            // 给每个一维数组赋值
            for (int j = 0; j < yangHui[i].length; j++) {
                if (j == 0 || j == yangHui[i].length - 1) {
                    yangHui[i][j] = 1;
                } else {
                    yangHui[i][j] = yangHui[i-1][j] + yangHui[i-1][j-1];
                }
            }
        }
        // 输出杨辉三角
        for (int i = 0; i < yangHui.length; i++) {
            for (int j = 0; j < yangHui[i].length; j++) {
                System.out.print(yangHui[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
