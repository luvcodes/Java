package Exception_1.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetail {
    public static void main(String[] args) throws ArithmeticException{
        f2();
    }

    // 这里的throws ArithmeticException是默认隐藏的
    public static void f2() throws ArithmeticException{
        /**
         * 1. 对于编译异常，程序中必须处理，比如 try-catch 或者 throws
         * 2. 对于运行时异常，程序中如果没有处理，默认就是throws的方式处理
         * */
        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }

    public static void f1() {
        // 报错原因：
        // 1. 因为f3方法抛出的是一个编译异常，就好像f1中有一个编译异常没有处理
        // 2. 即这时，就要求f1必须处理这个编译异常
        // 3. 在f1种，要么try-catch-finally 或者继续throws 这个编译异常
        // f3();
    }

    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("C:\\Users\\ryanw\\OneDrive\\Desktop\\practice_.test.txt");
    }

    public static void f4() {
        // 1. 这里在f4种调用方法f5 是OK 不报错
        // 2. 原因是f5 抛出的是运行异常，并不要求程序员显式处理
        f5();
    }

    public static void f5() throws ArithmeticException{

    }
}

class Father {
    public void method() throws RuntimeException {

    }
}
class Son extends Father {
    // 3. 子类重写父类方法时，对抛出异常的规定: 子类重写的方法，所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型。
    // 4. 在throws的过程中，如果有方法try-catch，就相当于处理异常，就可以不必throws (二选一)
    @Override
    public void method() throws ArithmeticException {

    }
}
