package mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ryanw
 */
public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*字节输入流循环读取*/

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\a.txt");
        // 循环读取
        int b;
        while ((b = fileInputStream.read()) != -1) {
            System.out.println((char) b);
        }

        fileInputStream.close();


        /**
         * read :表示读取数据，而且是读取一个数据就移动一次指针
         *
         FileInputStream fis = new FileInputStream("myio\\a.txt");
         //2.循环读取
         while ((fis.read()) != -1) {
         System.out.println(fis.read());//98  100  -1
         }
         //3.释放资源
         fis.close();*/
    }
}
