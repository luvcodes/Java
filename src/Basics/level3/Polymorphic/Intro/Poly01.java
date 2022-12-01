package Basics.level3.Polymorphic.Intro;

public class Poly01 {
    public static void main(String[] args) {
        Master master = new Master("Tom");
        Dog dog = new Dog("Mike");
        Bone bone = new Bone("Big bone");

        master.feed(dog, bone);

        Cat cat = new Cat("lisa");
        Fish fish = new Fish("test");
        master.feed(cat, fish);
        // 添加 给小猪喂米饭
        Pig pig = new Pig("小花猪");
        Rice rice = new Rice("米饭");
        master.feed(pig, rice);
    }
}
