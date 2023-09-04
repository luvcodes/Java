package TernaryOperator_;

public class TernaryOperator3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 99;
        int result = a < b ? a++ : b--;
        System.out.println(result);
        System.out.println(a);
        System.out.println(b);
    }
}
