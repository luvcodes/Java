package Basics.level1.for_loop.practice;

public class ForExercise02 {
    public static void main(String[] args) {
        // 输出：
        // 0 + 5 = 5
        // 1 + 4 = 5
        // 2 + 3 = 5
        // 3 + 2 = 5
        // 4 + 1 = 5
        // 5 + 0 = 5
        // 先输出 0 - 5
        // 后面的是 5 - i

        // 5替换成变量n
        int n = 5;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " + " + (n-i) + " = 5");
        }
    }
}
