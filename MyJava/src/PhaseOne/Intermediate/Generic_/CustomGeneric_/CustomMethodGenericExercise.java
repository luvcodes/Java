package PhaseOne.Intermediate.Generic_.CustomGeneric_;

public class CustomMethodGenericExercise {
    public static void main(String[] args) {
        Apple<String, Integer, Double> apple = new Apple<String, Integer, Double>();
        apple.fly(10); // 10会被自动装箱 Integer
        apple.fly(new Dog()); // Dog
    }
}

class Apple<T, R, M> {
    public<E> void fly(E e) {
        System.out.println(e.getClass().getSimpleName());
    }
    // 错误，U没有声明
    // public void eat(U u) {}
    public void run(M m) {}
}
class Dog{}