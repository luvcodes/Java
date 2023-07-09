package PhaseOne.Intermediate.Exception_.try_catch;

public class TryCatchDetail {
    public static void main(String[] args) {
        /*
        * 如果异常发生了，则异常后面发生的代码不会执行，直接进入到catch块
        * 如果异常没有发生，则顺序执行try的代码块，不会进入到catch
        * 如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)，则使用如下代码 - finally{}
        * */
        try {
            String str = "test";
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
