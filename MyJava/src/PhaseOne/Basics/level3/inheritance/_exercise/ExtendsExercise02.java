package PhaseOne.Basics.level3.inheritance._exercise;

public class ExtendsExercise02 {
    public static void main(String[] args) {
        F f = new F();
    }
}

class D {
    public D() {
        System.out.println("class D");
    }
}

class E extends D {
    public E() {
        System.out.println("Im non-parameter constructor");
    }
    public E(String name) {
        System.out.println(name + "Im class E's parameter constructor");
    }
}

class F extends E {
    public F() {
        this("hello");
        System.out.println("Im class F's non-parameter constructor");
    }
    public F(String name) {
        super("hahah");
        System.out.println("Im class F's parameter constructor");
    }
}