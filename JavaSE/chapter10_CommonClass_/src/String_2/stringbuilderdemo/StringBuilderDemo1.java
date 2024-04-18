package String_2.stringbuilderdemo;

/**
 * @author ryanw
 */
public class StringBuilderDemo1 {
    public static void main(String[] args) {
        // 这个例子是为了说明，这样直接赋值的方式会使得效率很低，所以引出 StringBuilder
        String s = "";
        for (int i = 0; i < 1000000; i++) {
            s = s + "abc";
        }
        System.out.println(s);
    }
}
