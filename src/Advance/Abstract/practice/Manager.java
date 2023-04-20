package Advance.Abstract.practice;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("Manager " + getName() + " is working");
    }
}
