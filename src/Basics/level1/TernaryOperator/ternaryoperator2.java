package Basics.level1.TernaryOperator;

public class ternaryoperator2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 99;
        int result = a > b ? a++ : --b;
        System.out.println(result);
    }
}
