package Array_.one_dimension.array_basic_1;

import java.util.Scanner;

public class initialize {
    public static void main(String[] args) {
        double[] scores = new double[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < scores.length; i++) {
            System.out.print("Please enter the " + (i+1) + "th element's value: ");
            scores[i] = scanner.nextDouble();
        }
        System.out.println();
        // iterate level2.array
        for (int i = 0; i < scores.length; i++) {
            System.out.println("The " + (i+1) + "th element is " + scores[i]);
        }
    }
}
