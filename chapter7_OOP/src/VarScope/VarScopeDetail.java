package VarScope;

/**
 * 属性和局部变量可以重名，访问时遵循就近原则
 * 在同一个作用域中，比如在同一个成员方法中，两个局部变量，不能重名
 * 属性生命周期较长，伴随着对象的创建而创建，伴随着对象的死亡而死亡。局部变量，
 * 生命周期较短，伴随着它的代码块的执行而创建，伴随着代码块的结束而死亡。即在一次方法调用过程中。
 * 作用域范围不同：
 *      全局变量/属性：可以本类使用，或其他类使用（通过对象调用）
 *      局部变量：只能在本类中对应的方法中使用
 * 修饰符不同：
 *      全局变量/属性可以加修饰符
 *      局部变量不可以加修饰符
 * */
public class VarScopeDetail {
    public static void main(String[] args) {
        Person person = new Person();
//        person.say(); // 当执行say方法时，say方法的局部变量比如name，会创建，当say执行完毕后
        // name局部变量就销毁，但是属性（全局变量）仍然可以使用
        T t = new T();
        t.test(); // 第一种跨类访问对象属性的方式

        t.test2(person); // 第二种跨类访问对象属性的访问
    }
}

class T {
    // 全局变量/属性：可以本类使用，或其他类使用（通过对象调用）
    public void test() {
        Person person = new Person();
        System.out.println(person.name); // jack
    }

    public void test2(Person p) {
        System.out.println(p.name);
    }
}

class Person {
    // 属性可以加修饰符（public protected private...）
    // 局部变量不能加修饰符
    public int age = 20;
    String name = "jack";
    public void say() {
        // 细节 属性和局部变量可以重名，访问时遵循就近原则
        String name = "king";
        System.out.println("say() name = " + name);
    }

    public void hi() {
        String address = "北京";
//        String address = "上海"; // 错误，重复定义变量
        String name = "hsp";
    }
}
