package PhaseOne.Intermediate.string_.stringbuffer_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null; // ok
        StringBuffer sb = new StringBuffer(); // ok
        sb.append(str);
        System.out.println(sb.length());

        System.out.println(sb);
        // 下面的构造器，会抛出NullpointerException
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
