package inheritance.firstpack;

// 大学生 -> 模拟大学生考试的简单情况
public class Graduate extends Pupil {
    public String name;
    public int age;
    private double score;
    public void setScore(double score) {
        this.score = score;
    }
    public void testing() {
        System.out.println("大学生: " + name + " 正在考大学数学");
    }
    public void showInfo() {
        System.out.println("大学生: " + name + " 年龄 " + age + " 成绩 " + score);
    }
}
