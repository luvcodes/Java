package String_2.stringdemo;

/**
 * @author ryanw
 */
public class StringDemo8 {
    public static void main(String[] args) {
        String result = reverse("abc");
        System.out.println(result);
    }

    /**
     * 字符串反转
     * @param str input string
     * @return reversed string result
     */
    public static String reverse(String str) {
        String result = "";
        // i 依次表示字符串中的每一个索引 （倒着的）
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            result = result + c;
        }

        return result;
    }
}
