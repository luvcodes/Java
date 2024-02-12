package this_keyword;

/**
 * this关键字可以用来访问本类的属性、方法、构造器
 * this用于区分当前类的属性和局部变量
 * 访问成员方法的语法：this.方法名(参数列表)
 * 访问构造器语法：this(参数列表); 注意只能在构造器中使用(即只能在构造器中访问另外一个构造器，必须放在第一条语句)
 * this不能在类定义的外部使用，只能在类定义的方法中使用
 *
 * @author ryanw
 * */
public class ThisDetail {
    public static void main(String[] args) {
        T t1 = new T();
//        t1.f2();
        t1.f3();

//        T t2 = new T();
    }
}

class T {
    String name = "jack";
    int num = 100;

    // 细节：访问成员方法的语法：this.方法名(参数列表)
    public void f1() {
        System.out.println("f1 method has been called");
    }
    public void f2() {
        System.out.println("f2 method has been called");
        // 调用本类的f1方法, 两种方法
        f1();
        this.f1();
    }

    public void f3() {
        String name = "smith"; // 局部变量定义了，传统方法就会由于就近原则来输出smith
        // 传统方法
        System.out.println("name = " + name + " num = " + num);
        // 用this访问属性
        System.out.println("name = " + this.name + " num = " + this.num);
    }

    // 细节：访问构造器语法：this(参数列表);
    // 注意只能在构造器中使用(即只能在构造器中访问另外一个构造器)
    public T() {
        // 这里去访问T(String name, int age)
        // 如果有访问构造器语法：this(参数列表); 必须放置为第一条语句
        this("jack", 100);
        System.out.println("T() 构造器");

    }
    public T(String name, int age) {
        System.out.println("T(String name, int age) 构造器");
    }
}