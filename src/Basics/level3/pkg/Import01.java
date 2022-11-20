package Basics.level3.pkg;

import java.util.*; // 表示将java.util包下的所有类都引入（导入）

public class Import01 {
    public static void main(String[] args) {
        int [] arr = {-1, 1, 2, 3, 4};
        Arrays.sort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
