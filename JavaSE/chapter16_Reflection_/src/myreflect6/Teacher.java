package myreflect6;

/**
 * @author ryanw
 */
public class Teacher {
    private String name;
    private double salary;

    public Teacher() {}

    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void teach(){
        System.out.println("老师在教书！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Teacher{name = " + name + ", salary = " + salary + "}";
    }
}
