package mytest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test09 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. 创建反序列化流的对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/mytest/aaa.txt"));
        
        // 2. 读取数据
        ArrayList<Student> list = (ArrayList<Student>) objectInputStream.readObject();
        
        // 3. 打印数据
        System.out.println(list);

        // 4. 释放资源
        objectInputStream.close();
    }
}
