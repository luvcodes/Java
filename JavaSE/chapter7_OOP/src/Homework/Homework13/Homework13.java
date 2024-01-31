package Homework.Homework13;
/**
 * (1) 做一个Student类，Student类有name，sex，age，stu_id，做合理封装，通过构造器在创建对象时将4个属性赋值
 * (2) 写一个Teacher类，Teacher类有name，sex，age，work_age，做合理封装，通过构造器在创建对象时将4个属性赋值
 * (3) 抽取一个父类Person类，将共同属性和方法放到Person类
 * (4) 学生需要有学习的方法，在方法里写上"我承诺，我会好好学习"
 * (5) 教师需要有教学的方法，在方法里写上"我承诺，我会认真教学"
 * (6) 学生和教师都有play 方法，学生玩的是足球，老师玩的是象棋，此方法是返回字符串的，分别返回"xx爱玩足球"和"xx爱玩象棋"。因为玩的
 * 方法名称都一样，所以要求此方法定义在父类中，子类实现重写。
 * 应当分析出，我们需要打印信息的方法，printInfo()
 * </p>
 * (7) 定义多态数组，里面保存2个学生和2个教师，要求按年龄从高到低排序
 * (8) 定义方法，形参为Person类型，功能：调用学生的study或教师的taech方法
 * */
public class Homework13 {
    public static void main(String[] args) {
        Student student = new Student("小明", '男', 15, "00023102");
        student.printInfo();
        System.out.println("----------------------");
        Teacher teacher = new Teacher("张飞", '男', 30, 5);
        teacher.printInfo();

        // 定义多态数组，里面保存2个学生和2个教师，要求按年龄从高到低排序
        Person[] persons = new Person[4];
        persons[0] = new Student("jack", '男', 10, "0001");
        persons[1] = new Student("mary", '女', 20, "0002");
        persons[2] = new Teacher("smith", '男', 36, 5);
        persons[3] = new Teacher("scott", '男', 26, 1);

        // 创建的对象
        Homework13 homework13 = new Homework13();
        homework13.bubbleSort(persons);

        // 输出排序后的数组
        System.out.println("---排序后的数组---");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        // 遍历数组，调用test方法
        System.out.println("========================");
        for (int i = 0; i < persons.length; i++) { // 遍历多态数组
            homework13.test(persons[i]);
        }
    }
    // 定义方法，形参为Peron类型，功能：调用学生的study或教师的teach方法
    // 分析这里会使用到向下转型和类型判断
    public void test(Person p) {
        if (p instanceof Student) { // p的运行类型如果是Student
            ((Student) p).study();
        } else if (p instanceof Teacher) {
            ((Teacher) p).teach();
        } else {
            System.out.println("do nothing...");
        }
    }


    // 方法，完成年龄从高到低排序
    public void bubbleSort(Person[] persons) {
        Person temp = null;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                // 判断条件
                if (persons[j].getAge() < persons[j + 1].getAge()) {
                    temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

}
