package VarScope;

/**
 * 在java编程中，主要的变量就是属性（成员变量）和局部变量
 * 我们说的局部变量一般是指在成员方法中定义的变量。
 * java中作用域的分类：
 *      全局变量：也就是属性，作用域为整个类体
 *      局部变量：也就是除了属性之外的其他变量，作用域为定义它的代码块中
 * 全局变量可以不赋值，直接使用，因为有默认值，局部变量必须赋值后，才能使用，因为没有默认值
 *
 * @author ryanw
 * */
public class VarScope {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.hi();
        cat.cry();
        cat.eat();
    }
}

class Cat {
    int age = 10;
    double weight; // 全局变量可以不赋值，直接使用，因为有默认值

    public void hi() {
        int num;
//        System.out.println("num = " + num); // 局部变量必须赋值后，才能使用，因为没有默认值
//        System.out.println("address = " + address);
        System.out.println("weight = " + weight);
    }

    public void cry() {
        // 1.局部变量一般是指在成员方法中定义的变量
        // 2.n和name就是局部变量
        // 3.n和name的作用域在cry方法中
        int n = 10;
        String name = "jack";
        System.out.println("在cry中使用属性 age = " + age);
    }
    public void eat() {
        System.out.println("在eat中使用属性 age = " + age);
//        System.out.println("在eat中使用属性 name = " + name);
    }
}
