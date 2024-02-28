package mybytestream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ryanw
 */
public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
           void write(int b)                       一次写一个字节数据
           void write(byte[] b)                    一次写一个字节数组数据
           void write(byte[] b, int off, int len)  一次写一个字节数组的部分数据
           参数一：数组
           参数二：起始索引  0
           参数三：个数      3
        */

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\outputstream_\\mybytestream\\a.txt");
        byte[] bytes = {97, 98, 99, 100};
        fileOutputStream.write(bytes, 1, 2);
        fileOutputStream.close();

        /*byte[] b = "后段程序员".getBytes();
        fileOutputStream.write(b);
        fileOutputStream.close();*/
    }
}
