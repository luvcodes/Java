package PhaseOne.Intermediate.CommonClasses_.String_2.stringbuffer_;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        /**
         * 输入商品名称和商品价格，要求打印效果示例，使用前面学习的方法完成:
         * 商品名  商品价格
         * 手机    123,564.59 // 比如 价格 3,456,789.88
         * 要求: 价格的小数点前面每三位用都好隔开，再输出
         *
         * 思路分析:
         * 1. 定义一个Scanner对象，接收用户输入的价格(String)
         * 2. 希望使用到StringBuffer的insert，需要将String转成StringBuffer
         * 3. 然后使用相关方法进行字符串的处理
         * */

        String price = "8123564.59";
        StringBuffer sb = new StringBuffer(price);
        // 先完成一个最简单的实现123,564.59
        // 找到小数点的索引，然后在该位置的前3为，插入，即可
        // int i = sb.lastIndexOf(".");
        // sb.insert(i - 3, ",");
        // System.out.println(sb);

        // 上面的两步需要做一个循环处理，才是正确的
        for (int i = sb.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);
    }
}
