package Basics.Homework.Homework05;

public class Homework05 {
    public static void main(String[] args) {
        Worker worker = new Worker("jack", 10000);
        worker.setSalMonth(15); // 灵活修改带薪月份
        worker.printSal();

        Peasant peasant = new Peasant("smith", 20000);
        peasant.printSal();

        Teacher teacher = new Teacher("Michael", 2000);
        // 老师有课时费
        teacher.setClassDay(360);
        teacher.setClassSal(5000);
        teacher.printSal();

        Scientist scientist = new Scientist("ted", 20000);
        scientist.setBonus(2000000);
        scientist.printSal();

        Waitor waitor = new Waitor("mark", 10000);
        waitor.setSalMonth(15);
        waitor.printSal();
    }
}
