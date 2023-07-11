package PhaseOne.Intermediate.CommonClasses_.String_2.Exercise;

public class StringExercise01 {
    public static void main(String[] args) {
        /**
         * 都指向的是字符串常量池中创建对象 叫做"abc"，分别将引用赋值给a和b
         * */
        String a = "abc";
        String b = "abc";
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
