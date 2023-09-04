package Input_;

import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        // 步骤：
        // 1. 引入Scanner类所在的包
        // 2. 创建Scanner对象实例
        Scanner scanner = new Scanner(System.in);
        // 3. 接收用户的输入
        System.out.print("Please enter your name: ");
        String name = scanner.next(); // 接收用户输入字符串

        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Please enter your salary: ");
        double salary = scanner.nextDouble();

        System.out.println("The user's infro is listed below");
        System.out.println("Name: " + name + " Age: " + age + " Salary: "+ salary);

    }
}
