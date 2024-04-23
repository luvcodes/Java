package myreflect4;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ryanw
 */
public class MyReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*
            Object invoke(Object obj, Object... args)：运行方法
            参数一：用obj对象调用该方法
            参数二：调用方法的传递的参数（如果没有就不写）
            返回值：方法的返回值（如果没有就不写）
        */

        // 1. 获取class字节码文件对象
        Class clazz = Class.forName("myreflect4.Student");

        // 2. 获取里面所有的公共方法对象(包含父类中所有的公共方法)
        /* Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/

        // 获取里面所有的方法对象(不能获取父类的，但是可以获取本类中私有的方法)
        /*Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/

        // 获取指定的单一方法
        Method m = clazz.getDeclaredMethod("eat", String.class);
        // System.out.println(m);

        // 获取方法的修饰符
        // int modifiers = m.getModifiers();
        // System.out.println(modifiers);

        // 获取方法的名字
        // String name = m.getName();
        // System.out.println(name);

        // 获取方法的形参
//        Parameter[] parameters = m.getParameters();
//        for (Parameter parameter : parameters) {
//            System.out.println(parameter);
//        }

        // 获取方法的抛出的异常
//        Class[] exceptionTypes = m.getExceptionTypes();
//        for (Class exceptionType : exceptionTypes) {
//            System.out.println(exceptionType);
//        }

        // 方法运行
        Student s = new Student();
        m.setAccessible(true);
        // 参数一 s：表示方法的调用者
        // 参数二 "汉堡包"：表示在调用方法的时候传递的实际参数
        String result = (String) m.invoke(s, "汉堡包");
        System.out.println(result);
    }
}