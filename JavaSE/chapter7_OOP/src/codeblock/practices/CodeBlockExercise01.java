package codeblock.practices;

public class CodeBlockExercise01 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.total);
        System.out.println(Person.total);
    }
}

class Person {
    public static int total;
    static {
        total = 100;
        System.out.println("In static block");
    }
}