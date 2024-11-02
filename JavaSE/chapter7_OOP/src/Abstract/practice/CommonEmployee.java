package Abstract.practice;

public class CommonEmployee extends Employee{
    // 重写抽象类的抽象方法
    @Override
    public void work() {
        System.out.println("Regular employee " + getName() + " is working.");
    }

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }
}
