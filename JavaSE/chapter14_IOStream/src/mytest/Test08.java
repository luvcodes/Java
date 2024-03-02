package mytest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test08 {
    public static void main(String[] args) throws IOException {
        /*
         * 需求：
         * 将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢？
         */

        // 1. 序列化多个对象
        Student s1 = new Student("zhangsan", 23, "南京");
        Student s2 = new Student("lisi", 24, "重庆");
        Student s3 = new Student("wangwu", 25, "北京");

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/mytest/aaa.txt"));
        objectOutputStream.writeObject(arrayList);

        objectOutputStream.close();
    }
}
