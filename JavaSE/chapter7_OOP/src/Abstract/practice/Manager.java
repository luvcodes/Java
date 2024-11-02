package Abstract.practice;

public class Manager extends Employee{
    private double bonus;

    // 调用抽象类的构造方法
    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // 实现抽象类中的抽象方法，确定方法体内容
    @Override
    public void work() {
        System.out.println("Manager " + getName() + " is working");
    }
}
