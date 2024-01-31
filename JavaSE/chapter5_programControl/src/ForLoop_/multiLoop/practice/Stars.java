package ForLoop_.multiLoop.practice;

public class Stars {
    public static void main(String[] args) {
        // 思路分析：
        // 1. 先打印一个矩形
//        *****
//        *****
//        *****
//        *****
//        *****
        for (int i = 1; i <= 5; i++) {
            System.out.println("*****");
        }
        System.out.println("");
        // 2. 打印半个金字塔
//        *
//        **
//        ***
//        ****
//        *****
        // i表示层数
        for (int i = 1; i <= 5; i++) {
            // 控制打印每层的*的个数
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // 每打印完一层的*后，就换行
            System.out.println("");
        }
        System.out.println("");
        // 3. 打印整个金字塔
//            * 第一层 1个* 2x1-1 4个空格=总层数-1
//           *** 第二层 3个* 2x2-1 3个空格=总层数-2
//          ***** 第三层 5个* 2x3-1 2个空格=总层数-3
//         ******* 第四层7个* 2x4-1 1个空格=总层数-4
//        ********* 第五层 9个* 2x5-1 0个空格=总层数-5
        for (int i = 1; i <= 5; i++) {
            // 在输出*之前还要输出空格 当前空格 = 总层数 - 当前层
            for (int k = 1; k <= (5-i); k++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2*i-1); j++) {
                System.out.print("*");
            }
            // 每打印完一层的*后，就换行
            System.out.println("");
        }
        System.out.println("");

        // 4. 打印空心金字塔
//            * 第一层 1个* 当前行的第一个位置是*，最后一个位置也是*
//           * * 第二层 2个* 当前行的第一个位置是*，最后一个位置也是*
//          *   * 第三层 2个* 当前行的第一个位置是*，最后一个位置也是*
//         *     * 第四层2个* 当前行的第一个位置是*，最后一个位置也是*
//        ********* 第五层 9个* 全部输出*
        for (int i = 1; i <= 5; i++) {
            // 在输出*之前还要输出空格 当前空格 = 总层数 - 当前层
            for (int k = 1; k <= (5-i); k++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                // 当前行的第一个位置是*，最后一个位置也是*，最后一层是全部输出
                if (j == 1 || j == (2 * i - 1) || i == 5) {
                    System.out.print("*");
                }
                // 其他情况输出空格
                else {
                    System.out.print(" ");
                }
            }
            // 每打印完一层的*后，就换行
            System.out.println("");
        }
        System.out.println("");

        // 先死后活
        // 5. 层数做成变量
        int totalLevel = 5;
        for (int i = 1; i <= totalLevel; i++) {
            // 在输出*之前还要输出空格 当前空格 = 总层数 - 当前层
            for (int k = 1; k <= (totalLevel-i); k++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                // 当前行的第一个位置是*，最后一个位置也是*，最后一层是全部输出
                if (j == 1 || j == (2 * i - 1) || i == totalLevel) {
                    System.out.print("*");
                }
                // 其他情况输出空格
                else {
                    System.out.print(" ");
                }
            }
            // 每打印完一层的*后，就换行
            System.out.println("");
        }
    }

}
