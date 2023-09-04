package debug;

import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {
        int[] arr = {8,-1,199,70,10};
        // Arrays.sort方法底层实现
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
