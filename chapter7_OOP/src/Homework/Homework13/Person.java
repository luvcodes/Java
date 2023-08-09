package Homework.Homework13;

public class Person { // 父类
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 编写play方法，把共有的输出内容写到父类
    public String play() {
        return name + "爱玩";
    }

    // 返回一个基本信息，共用的打印信息的方法，姓名，年龄，性别
    /**
     * 姓名：张飞
     * 年龄：30
     * 性别：男
     * */
    public String basicInfo() {
        return "姓名：" + name + "\n年龄：" + age + "\n性别：" + sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
