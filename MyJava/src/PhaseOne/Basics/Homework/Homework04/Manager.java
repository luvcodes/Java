package PhaseOne.Basics.Homework.Homework04;

public class Manager extends Employee{
    // 特有属性
    private double bonus;
    // 创建Manager对象时，奖金是多少并不是确定的
    public Manager(String name, double daySalary, int workDays, double grade) {
        super(name, daySalary, workDays, grade);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // 重写父类的printSal方法
    @Override
    public void printSal() {
        // 因为经理的工资计算方式和Employee不一样，所以我们重写
        System.out.println("经理 " + getName() + " 工资是 = " + (bonus + getDaySalary() * getWorkDays() * getGrade()));
    }
}
