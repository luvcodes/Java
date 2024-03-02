package mybytestream03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ryanw
 */
public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
         *   练习：文件拷贝
         *   注意：选择一个比较小的文件，不要太大。
         *   课堂练习：要求统计一下拷贝时间，单位毫秒
         * */

        long start = System.currentTimeMillis();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\copy.txt");

        // 拷贝
        int b;
        while ((b = fileInputStream.read()) != -1) {
            fileOutputStream.write(b);
        }

        fileInputStream.close();
        fileOutputStream.close();

        long stop = System.currentTimeMillis();

        System.out.println(stop - start);
    }
}
