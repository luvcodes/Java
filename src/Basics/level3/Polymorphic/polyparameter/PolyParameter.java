package Basics.level3.Polymorphic.polyparameter;

public class PolyParameter {
    public static void main(String[] args) {
        Worker worker = new Worker("Tom", 2500);
        Manager manager = new Manager("milan", 5000, 200000);
        PolyParameter polyParameter = new PolyParameter();
        polyParameter.showEmpAnnual(worker);
        polyParameter.showEmpAnnual(manager);

        polyParameter.testWork(worker);
        polyParameter.testWork(manager);
    }

    // 实现获取任何员工对象的年工资，并在main方法中调用该方法
    public void showEmpAnnual(Employee employee) {
        System.out.println(employee.getAnnual());
    }

    // 如果是普通员工，则调用work方法，如果是经理，则调用manage方法
    public void testWork(Employee employee) {
        if (employee instanceof Worker) {
            Worker worker = (Worker) employee;
            worker.work();
        } else if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            manager.manage();
        } else {
            System.out.println("No operation");
        }
    }
}
