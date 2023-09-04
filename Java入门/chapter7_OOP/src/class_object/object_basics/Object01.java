package class_object.object_basics;

public class Object01 {
    public static void main(String[] args) {
        Person a = new Person();
        a.age = 10;
        a.name = "小明";
        Person b;
        b = a;
        System.out.println(b.name);
        b.age = 200;
        b = null;
        System.out.println(a.age);
        System.out.println(b.age);
    }
}

class Person {
    int age;
    String name;
}
