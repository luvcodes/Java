package BackUpContents;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 定义Employee类
 * 1) 该类包含：private成员变量name,sal,birthday，其中 birthday 为 BackUpContents.MyDate 类的对象；
 * 2) 为每一个属性定义 getter, setter 方法；
 * 3) 重写 toString 方法输出 name, sal, birthday
 * 4) MyDate类包含: private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
 * 5) 创建该类的 3 个对象，并把这些对象放入 ArrayList 集合中（ArrayList 需使用泛型来定义），对集合中的元素进行排序，并遍历输出：
 *
 * 排序方式： 调用ArrayList 的 sort 方法 ,
 * 传入 Comparator对象[使用泛型]，先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
 */

@SuppressWarnings({"all"})

public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("ryan", 100000, new MyDate(2000, 11, 11)));
        employees.add(new Employee("ryan", 20000, new MyDate(2001, 12, 24)));
        employees.add(new Employee("bill", 50000, new MyDate(1980, 3, 6)));

        System.out.println("Employees: " + employees);

        // Sorting
        System.out.println("==对雇员进行排序==");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                // 先对参数传入的参数进行验证
                if (!(employee1 instanceof Employee && employee2 instanceof Employee)) {
                    System.out.println("Type incorrect");
                    return 0;
                }
                // 比较name
                int i = employee1.getName().compareTo(employee2.getName());
                if (i != 0) {
                    return i;
                }
                // 如果name相同，就比较birthday - year
                int yearMinus = employee1.getBirthday().getYear() - employee2.getBirthday().getYear();
                if (yearMinus != 0) {
                    // 说明比较出结果了，直接返回年
                    return yearMinus;
                }
                // year相同，就比较month
                int monthMinus = employee1.getBirthday().getMonth() - employee2.getBirthday().getMonth();
                if (monthMinus != 0) {
                    return monthMinus;
                }
                // 如果year 和 month都相同
                return employee1.getBirthday().getDay() - employee2.getBirthday().getDay();
            }
        });
        System.out.println("==After sorting==");
        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nBackUpContents.Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}


class MyDate {
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "BackUpContents.MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }
}