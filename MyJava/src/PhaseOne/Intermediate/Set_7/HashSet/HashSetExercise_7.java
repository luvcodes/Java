package PhaseOne.Intermediate.Set_7.HashSet;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise_7 {
    public static void main(String[] args) {
        /**
         定义一个Employee类，该类包含：private成员属性name,age 要求:
         创建3个Employee 对象放入 HashSet中
         当 name和age的值相同时，认为是相同员工, 不能添加到HashSet集合中

         如果不做hashCode重写或者equals方法的重写，这三个对象是三个不同的对象。
         首先进行了hash值运算，3个对象是3个不同的hash值，所以一定都是在不同的hashSet数组的不同index位置上
         */

        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("milan", 20));
        hashSet.add(new Employee("bill", 19));
        // 这里加不进去是因为，先验证了hashCode，hashCode相同，那么就比较后面的内容
        // 如果后面的内容不同，就加在链表的最后一位; 如果相同，就直接舍弃
//        hashSet.add(new Employee("milan", 20));
        // 这里能添加进去的原因是因为milan 21可以看作一个整体的key，这个整体的key和milan 20是不同的所以可以加进去。
        // 这里相当于是在table中占用了新的一个Node，不隶属于任何一个链表。追源码就可以看明白
        hashSet.add(new Employee("milan", 21));
        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
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
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //如果name 和 age 值相同，则返回相同的hash值
    // 因为这样的话，上面的两个milan就会只添加第一个，因为两个milan是重复的
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
