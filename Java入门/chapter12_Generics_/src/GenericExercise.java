import java.util.*;

@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args) {
        /**
         * 使用泛型方式给HashSet 放入3个学生对象
         * */
        Set<Student> students = new HashSet<Student>();
        students.add(new Student("ryan", 22));
        students.add(new Student("mark", 21));
        students.add(new Student("bill", 25));
        // iterate
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();

        /**
         * 使用泛型方式给HashMap 放入三个学生对象
         * */
        HashMap studentHashMap = new HashMap<String, Student>();
        studentHashMap.put("ryan", new Student("ryan", 22));
        studentHashMap.put("mark", new Student("mark", 21));
        studentHashMap.put("bill", new Student("bill", 25));
        // iterate
        Set<Map.Entry<String, Student>> entries = studentHashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next.getKey() + " - " + next.getValue());
        }
    }
}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
