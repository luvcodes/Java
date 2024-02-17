package String_2.stringbuffer_;

/**
 * @author ryanw
 */
public class StringBufferExercise01 {
    public static void main(String[] args) {
        // ok
        String str = null;
        // ok
        StringBuffer sb = new StringBuffer();
        // 需要看源码，底层调用的是 AbstractStringBuilder 的 appendNull
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);

        // 下面的构造器，会抛出NullpointerException
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
