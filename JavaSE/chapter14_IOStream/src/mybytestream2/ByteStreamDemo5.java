package mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ryanw
 */
public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {
      /*
          public int read(byte[] buffer)      一次读一个字节数组数据
      */

        FileInputStream fis = new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\a.txt");
        //2.读取数据
        byte[] bytes = new byte[2];
        //一次读取多个字节数据，具体读多少，跟数组的长度有关
        //返回值：本次读取到了多少个字节数据
        int len1 = fis.read(bytes);
        System.out.println(len1);
        String str1 = new String(bytes,0, len1);
        System.out.println(str1);

        int len2 = fis.read(bytes);
        System.out.println(len2);
        String str2 = new String(bytes,0, len2);
        System.out.println(str2);

        int len3 = fis.read(bytes);
        System.out.println(len3);
        String str3 = new String(bytes,0, len3);
        // ed 这里出问题，最后一个数据是e，为什么还输出d？
        System.out.println(str3);

        fis.close();
    }
}
