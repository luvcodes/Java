package PhaseOne.Advance.Abstract.practice;

public class CommonEmployee extends Employee{
    @Override
    public void work() {
        System.out.println("Regular employee " + getName() + " is working.");
    }

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }
}
