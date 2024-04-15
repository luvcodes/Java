package String_2;

import java.util.Scanner;

public class StringDemo3 {
    public static void main(String[] args) {
        // 1. 假设我现在键盘录入一个 abc
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串: ");
        String s1 = scanner.next();

        // 2. 代码中再定义一个字符串abc
        String str2 = "abc";

        // 3. 用==比较，这两者能一样吗？
        System.out.println(s1 == str2);

        // 结论: 以后只要想比较字符串的内容，就必须要用String里面的方法
    }
}
