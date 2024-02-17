package String_2.Exercise;

public class StringExercise04 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        String s2 = "java";
        String s4 = "java";
        // s3指向堆里面有一个value，value指向常量池里面的"java"
        String s3 = new String("java");
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        System.out.println(s2.equals(s3));
        // 字符串常量池中有两个字符串对象 hspedu和java
        System.out.println(s1 == s2);
    }
}
