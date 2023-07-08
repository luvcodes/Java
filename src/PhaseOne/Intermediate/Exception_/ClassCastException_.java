package PhaseOne.Intermediate.Exception_;

public class ClassCastException_ {
    public static void main(String[] args) {
        A b = new B(); // 向上转型
        B b2 = (B) b; // 向下转型，这里ok
        C c2 = (C) b; // 这样不行，因为B和C之间没有关系，抛出ClassCastException

    }

}

class A {}
class B extends A {}
class C extends A {}