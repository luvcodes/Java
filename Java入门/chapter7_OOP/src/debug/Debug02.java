package debug;

public class Debug02 {
    public static void main(String[] args) {
        // 数组越界的异常
        int[] arr = {1,10, -1};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Exit for");
    }
}
