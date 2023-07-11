package PhaseOne.Basics.Homework.Homework04;
/**
 * 父类 Employee
 * 子类 部门经理类 普通员工类
 * 部门经理工资 = 1000 + 单日工资*天数*等级（1.2） 分析出 奖金 + 基本工资
 * 普通员工工资 = 单日工资*天数*等级（1.0） 分析出 基本工资
 * 员工属性 姓名 单日工资 工作天数
 * 员工方法 打印工资
 * 普通员工及部门经理都是员工子类，需要重写打印工资方法
 * 定义并初始化普通员工对象，调用打印工资方法输出工资，定义并初始化部门经理对象，调用打印工资方法输出工资
 * */
public class Employee {
    // 属性
    // 员工属性：姓名 单日工资 工作天数
    private String name;
    private double daySalary;
    private int workDays;
    // 分析出还有一个属性等级
    private double grade;

    // 打印工资方法
    public void printSal() {
        System.out.println(name + " 工资 = " + daySalary * workDays * 1.0); // 这里是因为没有部门经理所有的奖金的，所以就用基础工资表达式
    }

    public Employee(String name, double daySalary, int workDays, double grade) {
        this.name = name;
        this.daySalary = daySalary;
        this.workDays = workDays;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySalary() {
        return daySalary;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
