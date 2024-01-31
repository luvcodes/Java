package inheritance.firstpack;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "jack";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(60);
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "ryan";
        graduate.age = 21;
        graduate.testing();
        graduate.setScore(100);
        graduate.showInfo();
    }
}
