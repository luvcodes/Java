package PhaseOne.Basics.Homework.Homework05;

public class Waitor extends Employee{
    public Waitor(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void printSal() {
        System.out.print("Waitor ");
        super.printSal();
    }
}
