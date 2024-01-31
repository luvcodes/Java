package Homework.Homework05;

public class Scientist extends Employee{
    // 特有属性
    private double bonus;
    // 方法

    public Scientist(String name, double sal) {
        super(name, sal);
    }

    // 重写年工资打印

    @Override
    public void printSal() {
        System.out.println("科学家");
        System.out.println(getName() + " 年工资是: " + (getSal() * getSalMonth() + bonus));
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
