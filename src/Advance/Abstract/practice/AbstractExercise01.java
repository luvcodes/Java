package Advance.Abstract.practice;

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manager manager = new Manager("Mark", 999, 50000);
        manager.setBonus(8000);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee("Ted", 888, 20000);
        commonEmployee.work();
    }
}