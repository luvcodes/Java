package ForLoop_.practice;

public class ForExercise {
    public static void main(String[] args) {
        // 打印1-100之间所有是9的倍数的整数，统计个数及总和
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 9 == 0) {
                System.out.println(i);
                sum += i;
                count += 1;
            }
        }
        System.out.println("Sum = " + sum);
        System.out.println("Count = " + count);
        System.out.println(" ");

    }
}
