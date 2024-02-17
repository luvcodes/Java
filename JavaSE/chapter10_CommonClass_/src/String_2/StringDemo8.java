package String_2;

/**
 * @author ryanw
 */
public class StringDemo8 {
    public static void main(String[] args) {
        String result = reverse("abc");
        System.out.println(result);
    }


    //1.我要干嘛？  --- 字符串的反转
    //2.我干这件事情，需要什么才能完成？  --- 需要一个字符串
    //3.调用处是否需要继续使用方法的结果呢？ ---需要结果进行输出
    public static String reverse(String str){
        String result = "";
        // i 依次表示字符串中的每一个索引 （倒着的）
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            result = result + c;
        }

        return result;
    }
}
