package mybufferedstream05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
         * 字符缓冲输出流
         * 构造方法：
         * public BufferedWriter(Writer r)
         * 特有方法：
         * public void newLine() 跨平台的换行
         */
        // 1. 创建字符缓冲输出流的对象
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/mybufferedstream1/b.txt"));
        // true参数表示可以在后面继续追加
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/mybufferedstream1/b.txt", true));

        // 2. 写出数据
        bufferedWriter.write("hello");
        bufferedWriter.newLine();
        bufferedWriter.write("world");
        bufferedWriter.newLine();

        // 3. 释放资源
        bufferedWriter.close();
    }
}
