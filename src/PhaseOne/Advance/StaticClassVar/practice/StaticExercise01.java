package PhaseOne.Advance.StaticClassVar.practice;

import PhaseOne.Basics.level3.modifier.Test;

public class StaticExercise01 {
    static int count = 9;
    public void count() {
        System.out.println("count = " + (count++));
    }

    public static void main(String[] args) {
        new StaticExercise01().count();
        new StaticExercise01().count();
        System.out.println(StaticExercise01.count);
    }
}


