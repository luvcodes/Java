package PhaseOne.Intermediate.Exception_.practices_;

public class Homework01 {
    public static void main(String[] args) {
        /**
         * 编写应用程序EcmDef.java, 接受命令行地两个参数(整数)，计算两数相除
         * 要求使用方法cal(int n1, int n2)
         * 对数据格式不正确(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException)、除0 进行异常处理
         * */
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("Index number incorrect");
            }

            // 先把接收到的参数，转成整数
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = cal(n1, n2); // method may throw ArithmeticException
            System.out.println("Result = " + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Number format incorrect, need to print integer");
        } catch (ArithmeticException e) {
            System.out.println("There are dividing zero condition");
        }
    }


    public static double cal(int n1, int n2){
            int res = n1 / n2;
            return res;
    }
}