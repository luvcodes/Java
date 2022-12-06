package Basics.level3.Polymorphic.polyarr;

public class Teacher extends Person{
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // 重写父类的say方法
    @Override
    public String say() {
        return super.say() + " salary=" + salary;
    }
}
