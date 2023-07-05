package PhaseOne.Intermediate.CommonClasses_.string_.Exercise;

public class StringExercise05 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";

        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name == p2.name);
        System.out.println(p1.name == "hspedu");

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2);
    }
}


class Person {
    public String name;
}