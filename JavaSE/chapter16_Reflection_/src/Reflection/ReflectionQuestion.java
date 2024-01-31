package Reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 这样通过使用反射，可以通过使用方法对象来直接访问方法，同时不需要修改源码。
 * 比如说我想要将method改为cry，而不再是hi方法，我只需要修改配置文件中的method就可以。
 * */
@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 使用Properties类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\Java入门\\chapter16_Reflection_\\src\\Reflection\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + methodName);

        /**
         * 使用反射机制解决
         * (1) 加载类 返回Class类型的对象，aClass就是classfullpath指定类的反射对象，也就是配置文件中定义的类
         * Class.forName(classfullpath); 这行代码通过反射机制加载了由变量classfullpath指定的类，并返回了这个类的Class对象。
         * 变量aClass中包含了该类的所有元数据信息，比如字段、方法等。
         * */
        Class aClass = Class.forName(classfullpath);

        /**
         * (2) 通过 aClass 得到你加载的类，Cat类的对象实例。创建这个类的一个新实例
         * */
        Object o = aClass.newInstance();
        System.out.println(o.getClass());

        /**
         * (3) 通过aClass得到你加载的类 Reflection.Cat的methodName的方法对象。在反射中，可以把方法视为对象(万物皆对象)
         * */
        Method method1 = aClass.getMethod(methodName);

        /**
         * (4) 通过method1 调用方法: 通过方法的对象来实现调用方法
         * 传统方法: 对象.方法()，反射机制里则是方法.invoke(对象)
         * */
        method1.invoke(o);
    }
}
