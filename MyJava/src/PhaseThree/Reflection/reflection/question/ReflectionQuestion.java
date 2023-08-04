package PhaseThree.Reflection.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // 根据配置文件 re.properties 指定信息，创建Cat对象并调用方法hi
        // 传统的方式 new 对象 -> 调用方法
//        Cat cat = new Cat();
//        cat.hi();



        // 1. 使用Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString(); // Cat
        String method = properties.get("method").toString(); // hi()
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + method);

        // 2. 创建对象，传统的方法，行不通 => 反射机制
        // new classfullpath()

        /**
         * 3. 使用反射机制解决
         * (1) 加载类 返回Class类型的对象
         * */
        Class aClass = Class.forName(classfullpath);
        /**
         * (2) 通过 cls 得到你加载的类 Cat类的对象实例
         * */
        Object o = aClass.newInstance();
        // (3) 通过aClass 得到你加载的类 Cat的 methodName 的方法对象
        //     即: 在反射中，可以把方法视为对象(万物皆对象)
        Method method1 = aClass.getMethod(method);
        // (4) 通过方法的对象来实现调用方法

    }
}
