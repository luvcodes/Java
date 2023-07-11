package PhaseOne.Intermediate.CommonClasses_.String_2.Exercise;

public class StringExercise03 {
    public static void main(String[] args) {
        // a指向常量池的"hsp"
        String a = "hsp";
        // b指向堆中对象，堆里面有一个对象value, 指向字符串常量池中的hsp(因为前一行字符串常量池中已经创建了hsp字符串对象
        String b = new String("hsp");
        // 比较字符串中的内容
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a == b.intern());
        // b是指向堆的，b.intern()是返回字符串常量池的地址
        System.out.println(b == b.intern());
    }
}
