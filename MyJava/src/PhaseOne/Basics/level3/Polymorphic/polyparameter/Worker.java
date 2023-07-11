package PhaseOne.Basics.level3.Polymorphic.polyparameter;

public class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }
    public void work() {
        System.out.println("Regular worker " + getName() + " is working!");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
