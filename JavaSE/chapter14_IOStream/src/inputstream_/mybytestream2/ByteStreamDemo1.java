package inputstream_.mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ryanw
 */
public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
         * 演示：字节输入流FileInputStream
         * 实现需求：读取文件中的数据。（暂时不写中文）
         *
         * 实现步骤：
         *       创建对象
         *       读取数据
         *       释放资源
         * */
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\a.txt");
        int b1 = fileInputStream.read();
        System.out.println((char) b1);
        int b2 = fileInputStream.read();
        System.out.println((char) b2);
        int b3 = fileInputStream.read();
        System.out.println((char) b3);
        int b4 = fileInputStream.read();
        System.out.println((char) b4);
        int b5 = fileInputStream.read();
        System.out.println(b5);

        fileInputStream.close();
    }
}
