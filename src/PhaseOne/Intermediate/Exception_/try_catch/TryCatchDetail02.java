package PhaseOne.Intermediate.Exception_.try_catch;

public class TryCatchDetail02 {
    public static void main(String[] args) {
        /**
         * 1. 如果try代码块有可能有多个异常
         * 2. 可以使用多个catch 分别捕获不同的异常 相应处理
         * 3. 要求子类异常要写在前面，父类异常写在后面
         */
        try {
            Person person = new Person();
            person = null;
            System.out.println("Name: " + person.getName()); // NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2; // ArithmeticException
        } catch (NullPointerException e) { // 这个Exception包括上面两种exception
            System.out.println("Empty pointer exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

        }

    }
}

class Person {
    private String name = "jack";

    public String getName() {
        return name;
    }
}
