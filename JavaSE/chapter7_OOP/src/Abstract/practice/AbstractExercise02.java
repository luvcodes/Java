package Abstract.practice;

public class AbstractExercise02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}

abstract class Animal {
    public Animal() {
        System.out.println("Animal constructor");
    }

    abstract void makeSound();
}

class Dog extends Animal {
    public Dog() {
        super();
        System.out.println("Dog constructor");
    }


    @Override
    public void makeSound() {
        System.out.println("Dog makeSound");
    }
}
