package myreflect1;

/**
 * @author ryanw
 */
@SuppressWarnings("all")
public class MyReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 获取Class对象的几种方式
         * */

        // 1. 第一种方式
        // 全类名 ： 包名 + 类名
        // 最为常用的
        // 使用这种方式来获取Class对象，会执行静态代码块
        Class clazz1 = Class.forName("myreflect1.Student");

        // 2. 第二种方式
        // 一般更多的是当做参数进行传递
        // 使用这种方式来获取Class对象，不会执行静态代码块
        Class clazz2 = Student.class;
        // // System.out.println(clazz2);

        // 3.第三种方式
        // 当我们已经有了这个类的对象时，才可以使用。
        // 使用这种方式来获取Class对象，会执行静态代码块
        // 这里涉及到一个很有意思的知识点叫做：泛型擦除。在Java中，泛型是在编译时进行类型检查的，
        // 而实际的类型信息在运行时会被擦除（Type Erasure），这意味着在运行时，JVM并不知道泛型的具体类型。
        Student s = new Student();
        Class clazz3 = s.getClass();
        // System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        Student student = new Student("张三", 23);
        // Class<Student> clazz = student.getClass(); // 报错
        Class<?> clazz = student.getClass();
    }
}
