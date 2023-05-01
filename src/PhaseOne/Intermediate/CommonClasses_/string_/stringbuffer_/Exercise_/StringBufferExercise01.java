package PhaseOne.Intermediate.CommonClasses_.string_.stringbuffer_.Exercise_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str); // 需要看源码，底层调用的是 AbstractStringBuilder 的 appendNull
        System.out.println(sb.length());

        System.out.println(sb); // null
        // 下面的构造器，会抛出NullpointerException
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
