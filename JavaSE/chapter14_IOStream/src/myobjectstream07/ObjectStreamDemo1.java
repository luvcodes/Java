package myobjectstream07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 *
 * Serializable接口里面是没有抽象方法，标记型接口
 * 一旦实现了这个接口，那么就表示当前的Student类可以被序列化
 * 理解：一个物品的合格证
 * */
public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
           需求：利用序列化流/对象操作输出流，把一个对象写到本地文件中
           构造方法：public ObjectOutputStream(OutputStream out)         把基本流变成高级流
           成员方法：public final void writeObject(Object obj)           把对象序列化（写出）到文件中去
        */
        // 1. 创建对象
        Student student = new Student("zhangsan", 23);

        // 2. 创建序列化流的对象/对象操作输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/myobjectstream/a.txt"));

        // 3. 调用序列化流的方法，把对象写到文件中
        oos.writeObject(student);

        // 4. 释放资源
        oos.close();
    }
}
