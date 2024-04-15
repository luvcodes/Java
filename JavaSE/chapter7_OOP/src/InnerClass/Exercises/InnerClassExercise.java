package InnerClass.Exercises;

/**
 * @author yangrunze
 */
public class InnerClassExercise {
    public static void main(String[] args) {
        Test.Inner r = new Test.Inner();
        System.out.println(r.a);
    }
}

class Test {
    public Test() {
        Inner s1 = new Inner();
        s1.a = 10;
        System.out.println(s1.a);
        Inner s2 = new Inner();
        System.out.println(s2.a);
    }

    static class Inner {
        public int a = 5; 
    }
}
