package Exception_1;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        /*
        * 1. num1 / num2 => 10 / 0
        * 2. 当执行到 num1 / num2 因为num2 = 0，程序就会抛出异常 ArithmeticException
        * 3. 当抛出异常后，程序就退出，崩溃了，下面的代码就不再执行
        * 4. Ctrl + Alt + t -> 选中try-catch
        * 5. 如果进行异常处理，那么即使出现了异常，程序可以继续执行
        * */
        try {
            int res = num1 / num2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Program continues...");
    }
}
