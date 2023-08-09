package Exception_.CustomException_;

public class CustomException {
    public static void main(String[] args) {
        /**
         *
         * */
        int age = 80;
        if (!(age >= 18 && age <= 120)) {
            throw new AgeException("Age need to be within 18 to 120");
        }
        System.out.println("You age range is correct");
    }
}

/**
 * 自定义一个异常
 * 1. 一般情况下，我们自定义异常是继承 RuntimeException
 * 2. 即把自定义异常做成 运行时异常，好处是，我们可以使用默认的异常机制
 * */
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}