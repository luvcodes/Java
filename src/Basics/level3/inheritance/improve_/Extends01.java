package Basics.level3.inheritance.improve_;

import Basics.level3.inheritance.firstpack.Graduate;
import Basics.level3.inheritance.firstpack.Pupil;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "jack";
        pupil.age = 11;
        pupil.testing();
        pupil.setScore(50);
        pupil.showInfo();

        System.out.println();
        Graduate graduate = new Graduate();
        graduate.name = "ryan";
        graduate.age = 23;
        graduate.testing();
        graduate.setScore(80);
        graduate.showInfo();
    }
}
