package inheritance.improve_;

/**
 * @author yangrunze
 */
public class Student {
    public String name;
    public int age;
    private double score;

    // 共有的方法
    public void setScore(double score) {
        this.score = score;
    }
    public void showInfo() {
        System.out.println("大学生: " + name + " 年龄 " + age + " 成绩 " + score);
    }
}
