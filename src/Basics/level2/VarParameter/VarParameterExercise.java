package Basics.level2.VarParameter;

public class VarParameterExercise {
    public static void main(String[] args) {
        HspMethod2 hspMethod = new HspMethod2();
        System.out.println(hspMethod.showScore("milan", 90.1, 80.0));
    }
}

/**
 * 有三个方法，分别实现返回姓名和两门课成绩(总分),
 * 返回姓名和三门课成绩(总分), 返回姓名和五门课成绩(总分)。
 * 封装成一个可变参数的方法
 * */
class HspMethod2 {
    public String showScore(String name, double... scores) {
        double totalScore = 0;
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
        }
        return name + "有" + scores.length + "门课的成绩总分为 = " + totalScore;
    }
}
