package CommonClasses_2.String_2.stringbuffer_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null; // ok
        StringBuffer sb = new StringBuffer(); // ok
        sb.append(str); // 需要看源码，底层调用的是 AbstractStringBuilder 的 appendNull
        System.out.println(sb.length());
        System.out.println(sb);
        // 下面的构造器，会抛出NullpointerException
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
