package Basics.Homework.Homework15;
/**
 * 见Homework16节课
 * */
public class Homework15 {
    public static void main(String[] args) {
        AAA obj = new BBB(); // 向上转型
        AAA b1 = obj; // b1和obj指向同一个对象, 都是指向BBB的
        System.out.println("obj的运行类型" + obj.getClass());
        obj = new CCC(); // 向上转型
        System.out.println("obj的运行类型" + obj.getClass());
        obj = b1;
        System.out.println("obj的运行类型" + obj.getClass());
    }
}

class AAA {

}

class BBB extends AAA {

}

class CCC extends BBB {

}