package StaticClassVar.practice;

public class StaticExercise02 {
    private int id;
    private static int total = 0;
    public static int getTotalPerson() {
        // id++; // 错误 注销
        return total;
    }
    public StaticExercise02()
    {
        total++;
        id = total;
    }
}

class TestPerson {
    public static void main(String[] args) {
        System.out.println("Total = " + StaticExercise02.getTotalPerson());
        StaticExercise02 staticExercise02 = new StaticExercise02();
        System.out.println("Total = " + staticExercise02.getTotalPerson());
    }
}
