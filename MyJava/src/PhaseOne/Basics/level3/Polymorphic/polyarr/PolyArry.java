package PhaseOne.Basics.level3.Polymorphic.polyarr;

public class PolyArry {
    public static void main(String[] args) {
        // 创建一个Person对象
        // 2个Student对象和2个Teacher对象，统一放在数组中，并调用每个对象say方法
        Person[] person = new Person[5];
        person[0] = new Person("jack", 20);
        person[1] = new Student("mary", 18, 100);
        person[2] = new Student("smith", 19, 30.1);
        person[3] = new Teacher("scott", 30, 20000);
        person[4] = new Teacher("king", 50, 25000);

        // 循环遍历多态数组，调用say
        for (int i = 0; i < person.length; i++) {
            // person[i] 编译类型是 Person，运行类型是根据实际情况有JVM来判断
            System.out.println(person[i].say()); // 动态绑定机制
            // 判断person[i]的运行类型是不是Student
            if (person[i] instanceof Student) {
                Student student = (Student)person[i]; // 向下转型
                student.study();
            } else if (person[i] instanceof Teacher) {
                Teacher teacher = (Teacher) person[i];
                teacher.teach();
            } else if (person[i] instanceof Person){
                // System.out.println("你的类型有误, 请自己检查...");
            } else {
                System.out.println("Your input value type is incorrect!");
            }
        }
    }
}
