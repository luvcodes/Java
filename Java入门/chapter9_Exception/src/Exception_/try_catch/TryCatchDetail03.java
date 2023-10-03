package Exception_.try_catch;

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
        // 由于finally无论如何都会执行，可是try语句中的一场在程序中没有捕捉，所以会抛出异常，println语句不会显示
        System.out.println("Program continue executes...");
    }
}
