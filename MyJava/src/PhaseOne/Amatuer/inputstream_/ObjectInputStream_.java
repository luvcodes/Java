package PhaseOne.Amatuer.inputstream_;

import PhaseOne.Amatuer.outputstream_.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //指定反序列化的文件
        String filePath = "C:\\Users\\ryanw\\IdeaProjects\\Java\\MyJava\\src\\PhaseOne\\Amatuer\\inputstream_\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取
        //1. 读取(反序列化)的顺序需要和你保存数据(序列化)的顺序一致
        //2. 否则会出现异常
        // 这里要对照outputstream_文件夹里面的ObjectOutStream_，因为读取的顺序和保存的顺序一致，data.dat里面的内容
        // 是根据ObjectOutStream_而保存的，所以ObjectOutStream_保存的顺序，就是ObjectInputStream_读取的顺序

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());

        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());

        //dog 的编译类型是 Object , dog 的运行类型是 Dog
        Object dog = ois.readObject();
        System.out.println("运行类型=" + dog.getClass());
        System.out.println("dog信息=" + dog);//底层 Object -> Dog

        //这里是特别重要的细节:
        //1. 如果我们希望调用Dog的方法, 需要向下转型
        //2. 需要我们将Dog类的定义，放在到可以引用的位置
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getName()); //旺财..

        //关闭流, 关闭外层流即可，底层会关闭 FileInputStream 流
        ois.close();
    }
}
