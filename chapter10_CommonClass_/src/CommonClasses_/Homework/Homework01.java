package CommonClasses_.Homework;

public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(str);
        try {
            str = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);
    }

    /**
     * (1) 将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
     * (2) 编写方法 public static String reverse(String str, int start, int end)
     * 思路分析
     * (1) 先把方法定义确定
     * (2) 把String 转成char[], 因为char[] 的元素是可以交换的
     * (3) 画出分析示意图
     * */
    public static String reverse(String str, int start, int end) {
        // 对输入的参数做一个验证
        // 重要的编程技巧！！！
        // (1) 写出正确的情况
        // (2) 然后取反即可
        if (!(str != null && start >= 0 && end > start && end < str.length())) {
            throw new RuntimeException("Parameter incorrect!");
        }

        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        // 使用chars 重新构建一个String 返回即可
        return new String(chars);

    }
}
