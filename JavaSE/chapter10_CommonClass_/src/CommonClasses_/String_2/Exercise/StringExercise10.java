package CommonClasses_.String_2.Exercise;

public class StringExercise10 {
    public static void main(String[] args) {
        Test ex = new Test();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
    }
}

class Test {
    String str = new String("hsp");
    final char[] ch = {'j','a','v','a'};
    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }
}
