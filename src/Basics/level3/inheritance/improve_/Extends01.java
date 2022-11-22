package Basics.level3.inheritance.improve_;

import Basics.level3.inheritance.Graduate;
import Basics.level3.inheritance.Pupil;

public class Extends01 {
    public static void main(String[] args) {
        Basics.level3.inheritance.Pupil pupil = new Pupil();
        pupil.name = "jack";
        pupil.age = 11;
        pupil.testing();
        pupil.setScore(50);
        pupil.showInfo();

        System.out.println();
        Basics.level3.inheritance.Graduate graduate = new Graduate();
        graduate.name = "ryan";
        graduate.age = 23;
        graduate.testing();
        graduate.setScore(80);
        graduate.showInfo();
    }
}
