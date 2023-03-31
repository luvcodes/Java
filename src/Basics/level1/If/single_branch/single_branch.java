package Basics.level1.If.single_branch;
import java.util.Scanner;

public class single_branch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();
        if (age == 18) {
            System.out.println("You are an adult from now on!");
        } else {
            System.out.println("Keep going!");
        }
    }
}
