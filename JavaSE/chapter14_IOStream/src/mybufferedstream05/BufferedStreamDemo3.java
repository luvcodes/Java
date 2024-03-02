package mybufferedstream05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
         * 字符缓冲输入流：
         * 构造方法：
         * public BufferedReader(Reader r)
         * 特有方法：
         * public String readLine() 读一整行
         */

        // 1.创建字符缓冲输入流的对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/mybufferedstream1/a.txt"));
        // 2.读取数据
        // 细节：
        // readLine方法在读取的时候，一次读一整行，遇到回车换行结束
        // 但是他不会把回车换行读到内存当中
        /*
        // 这样就读到的第一行
         * String line1 = br.readLine();
         * System.out.println(line1);
        // 这样就读到的第二行
         * String line2 = br.readLine();
         * System.out.println(line2);
         */
        
         String line;
         while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
         }

         // 3. 释放资源
         bufferedReader.close();

    }
}
