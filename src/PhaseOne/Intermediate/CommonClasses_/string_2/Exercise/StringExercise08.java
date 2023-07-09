package PhaseOne.Intermediate.CommonClasses_.string_2.Exercise;

public class StringExercise08 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";
        /**
         * 1. 先创建要给StringBuilder sb = StringBUilder();
         * 2. 执行 sb.append("hello");
         * 3. 执行 sb.append("abc");
         * 4. 调用 String s = sb.toString();
         * 最后其实是 c 指向堆中的对象(String) value[] -> 池中 "helloabc"
         * 一共有3个对象
         */
        String c = a + b;
        String d = "helloabc";
        // System.out.println(c == d); // false
        String e = "hello" + "abc"; // e指向常量池
        System.out.println(d == e); // true
    }
}
