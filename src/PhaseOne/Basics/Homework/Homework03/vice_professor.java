package PhaseOne.Basics.Homework.Homework03;

public class vice_professor extends Teacher{
    public vice_professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public void introduce() {
        System.out.println("这是副教授的信息");
        super.introduce();
    }
}
