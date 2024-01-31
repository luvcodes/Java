package class_object.method.memberMethodParameter;

public class MethodExercise02 {
    public static void main(String[] args) {
        // 编写方法copyPerson，复制一个Person对象，返回复制的对象。
        // 克隆对象
        // 得到新对象和原来的对象是两个独立的对象，只是他们的属性相同
        person p = new person();
        p.name = "milan";
        p.age = 100;
        // 创建tools
        MyTools myTools = new MyTools();
        person p2 = myTools.copyPerson(p);

        // 到此 p 和 p2是Person对象，但是是两个独立的对象
        System.out.println("p的属性 = " + p.name + " " + p.age);
        System.out.println("p2的属性 = " + p2.name + " " + p2.age);

    }
}
class person {
    String name;
    int age;
}

class MyTools {
    // 编写方法的思路
    // 1. 方法的返回类型Person
    // 方法的名字 copyPerson
    // 方法的形参
    // 方法体，创建一个新对象，并复制属性，返回即可
    public person copyPerson(person p) {
        // 创建一个新的对象
        person p2 = new person();
        p2.name = p.name;
        p2.age = p.age;

        return p2;
    }
}