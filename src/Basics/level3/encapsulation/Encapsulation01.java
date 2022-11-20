package Basics.level3.encapsulation;

/**
 * 封装的实现步骤
 * <p>
 * 1. 将属性进行私有化private 不能直接修改属性
 * 2. 提供一个公共的public set方法，用于对属性判断并赋值
 * 3. 提供一个公共的get方法，用于获取属性的值
 * </p>
 * */
public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("jack");
        person.setAge(30);
        person.setSalary(30000);
        System.out.println(person.info());
        System.out.println(person.getSalary());

        Person person1 = new Person("smith", 21, 30000);
        System.out.println("======smith的信息======");
        System.out.println(person1.info());
    }
}


// 年龄必须在1-120，年龄、工资不能直接查看，name的长度在2-6字符
class Person {
    public String name;
    private int age;
    private double salary;
    private String job;

    public Person(){}

    // 有三个属性的构造器
    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        // 我们可以将set方法写在构造器中，这样仍然可以验证
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // 加入对数据的校验, 相当于增加了业务逻辑
        if (name.length() >= 2 && name.length() <= 6){
            this.name = name;
        } else {
            System.out.println("名字的长度不对，需要(2-6)个字符，默认名字");
            this.name = "无名人";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // 判断 年龄必须在1-120
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("你设置的年龄不对，需要在（1-120），给默认年龄18");
            this.age = 18; // 给一个默认年龄
        }
    }

    public double getSalary() {
        // 可以这里增加对当前对象的权限判断
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    // 写一个方法，返回属性信息
    public String info() {
        return "信息为name = " + this.name + ", age = " + this.age + ", salary = " + this.salary;
    }
}