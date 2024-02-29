package mybufferedstream1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamDemo2 {
    public static void main(String[] args) throws IOException {
        // 1. 创建缓冲流的对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/mybufferedstream1/a.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/mybufferedstream1/copy2.txt"));
        
        // 2. 拷贝 (一次可读写多个字节)
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }

        // 3. 释放资源
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
