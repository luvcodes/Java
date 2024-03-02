package mybufferedstream05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
         * 需求：
         * 利用字节缓冲流拷贝文件
         *
         * 字节缓冲输入流的构造方法：
         * public BufferedInputStream(InputStream is)
         *
         * 字节缓冲输出流的构造方法：
         * public BufferedOutputStream(OutputStream os)
         *
         */

         // 1. 创建缓冲流的对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/mybufferedstream1/a.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/mybufferedstream1/copy.txt"));
        // 2. 循环读取并写到目标文件
        int b;
        while ((b = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(b);
        }

        // 3. 释放资源
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}
