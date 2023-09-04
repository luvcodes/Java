package Homework.Homework05;
/**
 * 设计父类 - 员工类。子类：Worker，Peasant，Teacher，Scientist，Waiter
 * 其中工人，农民，服务生只有基本工资sal
 * 教师除基本工资外，还有课酬（元/天）classDay，classSal
 * 科学家除基本工资外，还有年终奖bonus
 * 编写一个测试类，将各种类型的员工的全年工资打印出来
 * */
public class Employee {
    // 属性
    // 分析有一个带薪的月份
    private String name;
    private double sal;
    private int salMonth = 12;

    // 方法
    // 打印全年工资
    public void printSal() {
        System.out.println(name + " 年工资是: " + (sal * salMonth));
    }

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
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

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }
}
