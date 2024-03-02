package myobjectstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectStreamDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
           需求：利用反序列化流/对象操作输入流，把文件中的对象读到程序当中
           构造方法：public ObjectInputStream(InputStream out)         把基本流变成高级流
           成员方法：public Object readObject()                        把序列化到本地文件中的对象，读取到程序中来
        */
        
        // 1. 创建反序列化流的对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/myobjectstream/a.txt"));
        
        // 2. 读取数据
        Student student = (Student) objectInputStream.readObject();
    
        // 3. 打印对象
        System.out.println(student);

        // 4. 释放资源
        objectInputStream.close();

        
    }
}
