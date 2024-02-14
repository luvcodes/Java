package StaticClassVar.a03staticdemo3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //1.创建一个集合用来存储学生对象
        ArrayList<Student> list = new ArrayList<>();

        //2.创建3个学生对象
        Student stu1 = new Student("zhangsan",23,"男");
        Student stu2 = new Student("lisi",24,"女");
        Student stu3 = new Student("wangwu",25,"男");


        //3把学生对象添加到集合当中
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        //4.调用工具类中的方法
        int maxAgeStudent = StudentUtil.getMaxAgeStudent(list);

        System.out.println(maxAgeStudent);
    }
}
