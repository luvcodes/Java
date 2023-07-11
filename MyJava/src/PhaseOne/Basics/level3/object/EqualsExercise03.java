package PhaseOne.Basics.level3.object;

public class EqualsExercise03 {
    public static void main(String[] args) {
        int it = 65;
        float fl = 65.0f;
        System.out.println(it == fl);
        char ch1 = 'A';
        char ch2 = 12;
        System.out.println(it == ch1);
        System.out.println(12 == ch2);

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));
//        System.out.println("hello" == new java.sql.Date()); // 编译错误
    }
}
