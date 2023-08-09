package pkg;

import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        int [] arr = {-1, 1, 2, 3, 4};
        Arrays.sort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
