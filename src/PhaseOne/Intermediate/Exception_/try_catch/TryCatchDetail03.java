package PhaseOne.Intermediate.Exception_.try_catch;

public class TryCatchDetail03 {
    public static void main(String[] args) {
        // 这样相当于不管异常直接执行try然后finally，最后的输出语句不会执行。
        try {
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        } finally {
            System.out.println("执行了finally");
        }
        System.out.println("Program continue executes...");
    }
}
