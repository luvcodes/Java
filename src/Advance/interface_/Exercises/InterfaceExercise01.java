package Advance.interface_.Exercises;

public class InterfaceExercise01 implements A{
    public static void main(String[] args) {
        InterfaceExercise01 interfaceExercise01 = new InterfaceExercise01();
        System.out.println(interfaceExercise01.a);
        System.out.println(A.a);
        System.out.println(InterfaceExercise01.a);
    }
}

interface A {
    int a = 23;
}
