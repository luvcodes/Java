package Reflection.class_;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import Reflection.Car;

/**
 * 演示Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        String classAllPath = "Reflection.Car";
        //1 . 获取到Car类 对应的 Class对象
        //<?> 表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);

        //2. 输出cls
        System.out.println(cls); //显示cls对象, 是哪个类的Class对象 com.hspedu.Car
        System.out.println(cls.getClass());//输出cls运行类型 java.lang.Class

        //3. 得到包名
        System.out.println(cls.getPackage().getName());//包名

        //4. 得到全类名
        System.out.println(cls.getName());

        //5. 通过cls创建对象实例
        System.out.println();
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.toString()

        //6. 通过反射获取属性 brand
        System.out.println();
        Field brand = cls.getField("brand");
        System.out.println("Car value, " + brand.get(car));//宝马

        // 通过方法对象调用方法来得到方法体内的内容
        Method method = cls.getMethod("printMethod");
        method.invoke(car);

        //7. 通过反射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));//奔驰

        //8 我希望大家可以得到所有的属性(字段)
        System.out.println();
        System.out.println("=======所有的字段属性====");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());//名称
        }
    }
}
