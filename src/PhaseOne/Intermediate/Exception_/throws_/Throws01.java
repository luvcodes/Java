package PhaseOne.Intermediate.Exception_.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {
        /**
         * 1. 如果一个方法(中的语句执行时)可能生成某种异常，但是并不能确定如何处理这种异常，
         * 则此方法应显式地声明抛出异常，表示该方法将部队这些异常进行处理，而由该方法地调用者负责处理
         * */
    }

    public void f1() throws FileNotFoundException, NullPointerException, ArithmeticException {
        // 创建了一个文件流对象
        // 1. 这里的异常是一个FileInputStream 编译异常
        // 2. 使用前面讲过的 try-catch-finally
        // 3. 使用throws，抛出异常，让调用f1方法的调用者(方法)处理
        // 4. throws后面的异常类型可以是方法种产生的异常类型，也可以是它的父类
        // 5. throws关键字后也可以是 一场列表，即可以抛出多个异常
        FileInputStream fis = new FileInputStream("C:\\Users\\ryanw\\OneDrive\\Desktop\\test.txt");
    }
}
