package PhaseOne.Basics.level2.array.one_dimension.array_expand_5;

import java.util.Scanner;

public class ArrayAdd {
    public static void main(String[] args) {
        // 原始数组使用静态分配
        // 增加的元素放在数组的最后
        // 用户可以通过输入来决定是否继续添加，y/n

        // 思路分析：
        // 定义初始数组
        // 定义新数组 int[] arr2 = new int[arr.length+1];
        // 遍历arr数组，依次将arr的元素拷贝到arr2数组
        // 将4赋给arr2[arr2.length-1] = 4; 把4赋给arr2最后一个元素
        // 让arr指向arr2，arr = arr2，那么，原来arr数组就被销毁
        // 创建一个Scanner，因为用户什么时候退出不确定, do-while + break控制
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1,2,3};
        do {
            // 定义新数组
            int[] arr2 = new int[arr.length+1];
            // 数组拷贝
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = arr[i];
            }
            // 用户输入
            System.out.println("请输入你要添加的元素: ");
            int addNum = scanner.nextInt();

            arr2[arr2.length - 1] = addNum; // addNum就是加在最后一位的数字
            arr = arr2;

            // 遍历数组
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            // 问用户是否继续
            System.out.print("是否继续添加 y/n? ");
            char key = scanner.next().charAt(0);
            if (key == 'n') {
                break;
            }
        } while (true);
        System.out.println("你退出了添加");
    }
}
