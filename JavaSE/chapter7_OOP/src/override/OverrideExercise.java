package override;

/**
 * @author ryanw
 */
public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("jack", 10);
        System.out.println(person.say());

        Student student = new Student("smith", 20, 123456, 99.8);
        System.out.println(student.say());
    }
}
