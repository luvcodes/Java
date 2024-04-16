package String_2.stringdemo;

import java.util.Scanner;

public class StringDemo4 {
    public static void main(String[] args) {
        String correctUsername = "zhangsan";
        String correctPassword = "123456";
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Correct!");
                break;
            } else {
                if (i == 2) {
                    System.out.println("Incorrect! Account has been locked, please contact administrator");
                } else {
                    System.out.println("User login failed, username or password incorrect, you have " + (2 - i) + " times remaining.");
                }
            }
        }
    }
}
