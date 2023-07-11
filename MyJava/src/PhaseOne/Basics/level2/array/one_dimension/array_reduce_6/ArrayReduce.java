package PhaseOne.Basics.level2.array.one_dimension.array_reduce_6;

import java.util.Scanner;

public class ArrayReduce {
    public static void main(String[] args) {
        // 将数组进行缩减，询问用户是否继续缩减，缩减最后一位的元素
        // 当只剩下最后一个元素时，提示，不能再缩减;
        int[] arr1 = {1,2,3,4};
        Scanner scanner = new Scanner(System.in);

        do {
            int[] arr2 = new int[arr1.length - 1];
            // level2.array clone
            for (int i = 0; i < arr1.length-1; i++) { // 只拷贝4个空间
                arr2[i] = arr1[i];
            }

            // print arr1
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(arr1[i] + "\t");
            }

            arr1 = arr2;

            if (arr1.length == 0) {
                System.out.println("Exit the program");
                break;
            }

            System.out.print("Do you want to delete y/n? ");
            char check = scanner.next().charAt(0);

            if (check == 'n') {
                break;
            }
        } while (true);
    }
}
