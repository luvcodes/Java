package PhaseOne.Intermediate.Exception_.practices_;

public class ThrowException {
    public static void main(String[] args) {
        try {
            ReturnExceptionDemo.methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ReturnExceptionDemo.methodB();
    }
}

class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("Enter method A");
            throw new RuntimeException("Create exception");
        } finally {
            System.out.println("Use the finally from A method");
        }
    }

    static void methodB() {
        try {
            System.out.println("Enter method B");
            return;
        } finally {
            System.out.println("Use the finally from B method");
        }
    }
}
