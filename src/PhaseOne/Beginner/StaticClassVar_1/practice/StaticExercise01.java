package PhaseOne.Beginner.StaticClassVar_1.practice;

public class StaticExercise01 {
    static int count = 9;
    // 这个count是后加加，所以相当于先输出，后加一
    public void count() {
        System.out.println("count = " + (count++));
    }

    public static void main(String[] args) {
        new StaticExercise01().count();
        new StaticExercise01().count();
        System.out.println(StaticExercise01.count);
    }
}


