package objectEquals;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person person1 = new Person("jack", 10, 'a');
        Person person2 = new Person("jack", 10, 'a');
        System.out.println(person1.equals(person2)); // Object的equals判断是不是同一个对象，返回false

    }
}

// 判断两个Person对象的内容是否相等, 而不是比较地址
// 如果两个Person对象的各个属性值都一样，则返回true，反之false
// 需要重写equals方法
class Person {
    private String name;
    private int age;
    private char gender;

    // 重写Object的equals方法
    public boolean equals(Object obj) {
        // 判断如果比较的两个对象是同一个对象，则直接返回true
        if (this == obj) {
            return true;
        }
        // 类型判断
        // 判断是否为Person
        if (obj instanceof Person) {
            // 进行 向下转型，因为我需要得到obj的各个属性
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender; // age和gender用等于是因为这两个是基本数据类型
        }
        // 如果不是Person，则直接返回false
        return false;
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}