package PhaseOne.Amatuer.outputstream_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String filePath = "C:\\Users\\ryanw\\IdeaProjects\\Java\\MyJava\\src\\PhaseOne\\Amatuer\\outputstream_\\data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化数据到 C:\Users\ryanw\IdeaProjects\Java\MyJava\src\PhaseOne\Amatuer\outputstream_\data.dat
        oos.writeInt(100);// int -> Integer (实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("韩顺平教育");//String
        //保存一个dog对象
        oos.writeObject(new Dog("旺财", 10, "日本", "白色"));
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");


    }
}
