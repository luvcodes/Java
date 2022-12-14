package Basics.Homework.Homework11;
/**
 * 现有Person类，里面有方法run，eat，Student类继承了Person类，并重写了run方法
 * 自定义了study方法，试写出对象向上转型和向下转型的代码，并写出格子都可以调用哪些方法，并写出方法输出什么
 * */
public class Homework11 {
    public static void main(String[] args) {
        // 向上转型：父类的引用指向子类对象
        Person p = new Student();
        // 可以调用共有同名方法，可以调用父类的方法，不能调用子类的独特方法
        p.run(); // student run
        p.eat(); // person eat

        // 向下转型：把指向子类对象的父类引用，转成指向子类对象的子类引用
        Student s = (Student)p;
        s.run(); // student run
        s.study(); // student study
        s.eat(); // person eat
    }
}

class Person {
    public void run() {
        System.out.println("person run");
    }
    public void eat() {
        System.out.println("person eat");
    }
}

class Student extends Person{
    public void run() {
        System.out.println("student run");
    }
    public void study() {
        System.out.println("student study");
    }
}

