package Basics.level1.If.double_branch;

import java.util.Scanner;

public class double_branch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();
        if (age > 18) {
            System.out.println("You are older than 18, you have to take responsibility for your behaviour.");
        } else {
            System.out.println("Not this time!");
        }
        System.out.println("Program continues.");

    }
}
