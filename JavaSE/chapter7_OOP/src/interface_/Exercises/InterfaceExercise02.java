package interface_.Exercises;

public class InterfaceExercise02 {
    public static void main(String[] args) {
        new C().pX();
    }
}

interface AA {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements AA {
    public void pX() {
        // System.out.println(x); // 错误，原因不明确x
        // 可以明确的指定x
        // 访问接口的x就是用A.x
        // 访问父类的x就使用super.x
        System.out.println(AA.x + " " + super.x);
    }
}
