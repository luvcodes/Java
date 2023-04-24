package PhaseOne.Basics.level2.array.two_dimension;

public class TwoDimArray02 {
    public static void main(String[] args) {
        // 使用方式1: 动态初始化方式1:
//        int[][] arr = new int[2][3];

        // 使用方式2: 初始化方式2:
        int arr[][]; // 声明二维数组
        arr = new int[2][3];

        arr[1][1] = 8;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
