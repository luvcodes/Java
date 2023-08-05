package Exception_1.try_catch;

public class TryCatchDetail {
    public static void main(String[] args) {
        /**
        * 如果异常发生了，则异常后面发生的代码不会执行，直接进入到catch块
        * 如果异常没有发生，则顺序执行try的代码块，不会进入到catch
        * 如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)，则使用如下代码 - finally{}
         *
         * 在try代码块中可能有异常，那么在catch代码块中捕获到异常
         * 1. 当异常发生时
         * 2. 系统将异常封装成Exception对象e，传递给catch
         * 3. 得到异常对象后，程序员自己处理
         * 4. 注意，如果没有发生异常，catch代码块不执行
        * */
        try {
            String str = "practice_.test";
            int a = Integer.parseInt(str);
            System.out.println("Number: " + a);
        } catch (NumberFormatException e) {
            System.out.println("Exception message = " + e.getMessage());
        } finally {
            System.out.println("Finally code block has been executed");
        }
        System.out.println("Program continues...");


//        int num1 = 10;
//        int num2 = 0;
//        try {
//            int res = num1 / num2;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}
