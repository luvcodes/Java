package Reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 根据配置文件 re.properties 指定信息，创建Cat对象并调用方法hi
        // 传统的方式 new 对象 -> 调用方法
//        Cat cat = new Cat();
//        cat.hi();

        // 1. 使用Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\Java入门\\chapter16_Reflection_\\src\\Reflection\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString(); // Cat
        String methodName = properties.get("method").toString(); // hi()
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + methodName);

        /**
         * 3. 使用反射机制解决
         * (1) 加载类 返回Class类型的对象，aClass 就是 classfullpath 指定类的反射对象。
         * Class.forName(classfullpath); 这行代码通过反射机制加载了由变量 classfullpath 指定的类，并返回了这个类的 Class 对象。
         * 这个 Class 对象存储在变量 aClass 中，它包含了该类的所有元数据信息，比如字段、方法等。
         * */
        // 加载指定的类，其完整路径由变量 classfullpath 提供，在这里就是Cat，因为在配置文件中写的就是Cat
        Class aClass = Class.forName(classfullpath);
        /**
         * (2) 通过 aClass 得到你加载的类 Cat类的对象实例
         * 创建这个类的一个新实例
         * */
        Object o = aClass.newInstance();
        /**
         * (3) 通过aClass 得到你加载的类 Reflection.Cat的 methodName 的方法对象
         *          即: 在反射中，可以把方法视为对象(万物皆对象)
         *     这里不能直接使用 Cat cat = (Cat) o; cat. hi(); 因为应该是从配置文件里读取方法，而不是直接强转再调用方法。
         *     如果mysql配置文件里写的不是hi方法，那么就会形成错误了。
         *
         *     查找这个类中名为 methodName 的方法。
         * */
        Method method1 = aClass.getMethod(methodName);
        System.out.println("================");
        // (4) 通过method1 调用方法: 通过方法的对象来实现调用方法
        // 传统方法: 对象.方法()，反射机制 方法.invoke(对象)
        method1.invoke(o);
        /**
         * 这样通过使用反射，可以通过使用方法对象来直接访问方法，同时不需要修改源码。
         * 比如说我想要将method改为cry，而不再是hi方法，我只需要修改配置文件中的method就可以，不需要修改该Cat类中的方法。
         * */
    }
}
