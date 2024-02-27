package inputstream_.mybytestream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ryanw
 */
public class ByteStreamDemo6 {
    public static void main(String[] args) throws IOException {
        /*
         *   练习：
         *       文件拷贝
         *       把D:\itheima\movie.mp4 (16.8 MB) 拷贝到当前模块下。
         *
         * */

        long start = System.currentTimeMillis();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\c.txt");

        int len;
        byte[] bytes = new byte[1024 * 1024 * 5];
        while ((len = fileInputStream.read()) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        fileInputStream.close();
        fileOutputStream.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
