package Set_7;

import java.util.Objects;

/**
 * @author ryanw
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    //this：表示当前要添加的元素
    //o：表示已经在红黑树存在的元素
    //返回值：
    //负数：表示当前要添加的元素是小的，存左边
    //正数：表示当前要添加的元素是大的，存右边
    //0 :表示当前要添加的元素已经存在，舍弃
    @Override
    public int compareTo(Student o) {
        System.out.println("--------------");
        System.out.println("this:" + this);
        System.out.println("o:" + o);
        //指定排序的规则
        //只看年龄，我想要按照年龄的升序进行排列
        // this是当前要添加的元素，o是当前已经存在树中的要进行比较的元素
        return this.getAge() - o.getAge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
