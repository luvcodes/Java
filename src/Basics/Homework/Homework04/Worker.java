package Basics.Homework.Homework04;

public class Worker extends Employee{
    // 分析普通员工没有特有的属性
    public Worker(String name, double daySalary, int workDays, double grade) {
        super(name, daySalary, workDays, grade);
    }

    // 重写printSal
    // 由于普通员工和Employee的工资计算方法相同，所以直接调用父类的printSal()
    @Override
    public void printSal() {
        System.out.print("普通员工 ");
        super.printSal();
    }
}
