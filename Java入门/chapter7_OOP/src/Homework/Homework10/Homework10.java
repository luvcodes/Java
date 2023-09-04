package Homework.Homework10;

import javax.print.Doc;

/**
 * 编写Doctor类，相应的getter和setter方法，5个参数的构造器
 * */
public class Homework10 {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("jack", 20, "dentist", 'M', 20000);
        Doctor doctor2 = new Doctor("jack", 20, "dentist", 'M', 20000);
        System.out.println(doctor1.equals(doctor2)); // T

        Doctor doctor3 = new Doctor("jack", 20, "dentist", 'M', 20000);
        Doctor doctor4 = new Doctor("jack", 21, "dentist", 'M', 20000);
        System.out.println(doctor3.equals(doctor4)); // F
    }
}
