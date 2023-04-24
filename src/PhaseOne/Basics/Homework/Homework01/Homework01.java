package PhaseOne.Basics.Homework.Homework01;
/**
 * 定义一个Person类，name，age，job，初始化Person对象数组，有3个Person对象
 * 并按照age从大到小进行排序，提示，使用冒泡排序
 * */
public class Homework01 {
    public static void main(String[] args) {
        // 初始化Person对象数组，有3个Person对象
        Person[] persons = new Person[3];
        persons[0] = new Person("jack", 10, "Java EE engineer");
        persons[1] = new Person("tom", 50, "Big Data engineer");
        persons[2] = new Person("mary", 30, "PHP engineer");

        // 输出当前对象数组
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]); // 默认调用对象的toString方法
        }

        // 使用冒泡排序
        Person temp = null; // 临时变量，用于交换
        for (int i = 0; i < persons.length - 1; i++){
            for (int j = 0; j < persons.length - 1 - i; j++) {
                // 并按照age从大到小进行排序, 如果前面的人的age < 后面的人的age，就交换
                // 要求按照名字的长度从小到大 persons[i].getName().length() > persons[i + 1].getName().length()
                if (persons[i].getAge() < persons[i+1].getAge()) {
                    temp = persons[i];
                    persons[i] = persons[i + 1];
                    persons[i + 1] = temp;
                }
            }
        }

        System.out.println("排序后的效果");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]); // 默认调用对象的toString方法
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}