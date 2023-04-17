package Basics.level1.TernaryOperator;

public class ternaryoperator1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 99;
        // b--是先返回b的值，然后再b-1
        int result = a > b ? a++ : b--;
        System.out.println(result); // 99
    }
}
