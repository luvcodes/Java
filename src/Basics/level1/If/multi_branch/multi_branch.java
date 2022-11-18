package Basics.level1.If.multi_branch;

import java.util.Scanner;

public class multi_branch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your credit points(1-100): ");
        int credit = scanner.nextInt();
        if (credit >= 1 && credit <= 100) {
            if (credit == 100) {
                System.out.println("信用极好");
            } else if (credit > 80 && credit < 99) {
                System.out.println("信用优秀");
            } else if (credit >= 60 && credit <= 80) {
                System.out.println("信用一般");
            } else {
                System.out.println("信用不及格");
            }
        } else {
            System.out.println("Credit points need to within 1-100, please enter again: ");
        }

        boolean b = true;
        if (b == false) { // 如果if(b=false)编译也能通过，输出c，因为这个条件表达式本身就是false，不会输出a
            System.out.println("a");
        } else if (b) {
            System.out.println("b");
        } else if (!b) {
            System.out.println("c");
        } else {
            System.out.println("d");
        }
    }
}
