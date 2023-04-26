package PhaseOne.Intermediate.string_.Exercise;

public class StringExercise03 {
    public static void main(String[] args) {
        String a = "hsp"; // a指向常量池的"hsp"
        String b = new String("hsp"); // b指向堆中对象，堆里面有一个对象value, 指向字符串常量池中的hsp
        System.out.println(a.equals(b)); // 比较字符串中的内容
        System.out.println(a == b);
        System.out.println(a == b.intern());
        System.out.println(b == b.intern()); // b是指向堆的，b.intern()是返回常量池的地址
    }
}
