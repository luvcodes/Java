// package的作用是生命当前类所在的额包，需要放在类的最上面
// 一个类中最多只有一句package
package pkg;

import java.util.Arrays;
import java.util.Scanner;

public class PdgDetail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1,2,3,4,5};
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
