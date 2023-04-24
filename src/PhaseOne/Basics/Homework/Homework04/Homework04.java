package PhaseOne.Basics.Homework.Homework04;

public class Homework04 {
    public static void main(String[] args) {
        Manager manager = new Manager("刘备", 100, 20, 1.2);
        // 设置奖金，因为奖金是不确定的，创建对象以后再确定
        manager.setBonus(3000);
        manager.printSal();

        Worker worker = new Worker("关羽", 50, 10, 1.0);
        worker.printSal();
    }
}
