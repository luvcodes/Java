package inputstream03_.mybytestream2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ryanw
 */
public class ByteStreamDemo9 {
    /*
     *    JDK9:IO流中捕获异常的写法
     * */
//    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\a.txt");
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\inputstream_\\mybytestream2\\c.txt");
//
//        try (fis;fos) {
//            //2.拷贝
//            int len;
//            byte[] bytes = new byte[1024 * 1024 * 5];
//            while ((len = fis.read(bytes)) != -1) {
//                fos.write(bytes, 0, len);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
