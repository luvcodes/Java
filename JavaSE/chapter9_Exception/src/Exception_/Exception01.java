package Exception_;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        /*
        * 1. num1 / num2 => 10 / 0
        * 2. 当执行到 num1 / num2。因为num2 = 0，程序就会抛出异常 ArithmeticException
        * 3. 当抛出异常后，程序就退出，崩溃了，下面的代码就不再执行。如果进行异常处理，那么即使出现了异常，程序可以继续执行
        * */
        try {
            int res = num1 / num2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /**
         * 这行输出语句不会输出的原因:
         * 在Java中，当一个异常被抛出并且没有被捕获，它会导致当前执行的线程立即停止，并且异常信息会被输出到控制台。
         * 这也意味着当前线程中该异常之后的代码不会被执行。
         * 当遇到`10 / 0`这个算术错误时，会抛出一个`ArithmeticException`。
         * 这个异常在`try`块中被捕获。然后，在`catch`块中，你又抛出了一个新的异常，`RuntimeException`。
         * 当`RuntimeException`被抛出，它并没有在任何地方被捕获（你的代码中并没有包含处理这个异常的额外的`catch`块），所以它会导致程序立即停止执行。
         * 因此，`System.out.println("Program continues...");`这行代码位于`RuntimeException`被抛出之后，所以它不会被执行。
         * 总结：由于`RuntimeException`在`catch`块中被抛出并且没有被后续代码捕获，程序立即停止，这就是为什么`println`语句没有执行的原因。
         * */
        System.out.println("Program continues...");
    }
}
