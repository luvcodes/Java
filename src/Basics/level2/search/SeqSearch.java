package Basics.level2.search;

import java.util.Scanner;

public class SeqSearch {
    public static void main(String[] args) {
        /*
         * 有一个数列，从键盘任意输入一个名称，判断数列中是否
         * 包含此名称[顺序查找]
         * 如果找到了，就提示找到，并给出下标值
         *
         * 思路:
         * 定义字符串数组
         * 接收用户输入，遍历数组，逐一比较，如果有，则提示信息，并退出
         * */
        String[] names = {"a", "b", "c", "d"};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter name: ");
        String findName = scanner.next();

        // 遍历数组，逐一比较，如果有，则提示信息，并退出
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            // 比较字符串用equals
            if (findName.equals(names[i])) {
                System.out.println("Congratulations of finding " + findName);
                System.out.println("The index of it is " + i);
                // 这样就可以查看index是否被改变，也就能检测是不是进入此if了
                index = i;
                break;
            }
        }

        // 如果index还等于-1，说明没有进入for循环里的if语句块，说明没找到
        if (index == -1) {
            System.out.println("Sorry, we didn't found the name!");
        }
    }
}
