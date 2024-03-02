package myconvertstream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * @author ryanw
 */
public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
         * 利用转换流按照指定字符编码写出
         */

        // // 1. 创建转换流的对象
        // OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new
        // FileOutputStream("src/myconvertstream/b.txt"), "GBK");
        // // 2. 写出数据
        // outputStreamWriter.write("你好你好");
        // // 3. 释放资源
        // outputStreamWriter.close();

        // JDK 11 替代方案
        FileWriter fw = new FileWriter("src/myconvertstream/c.txt", Charset.forName("GBK"));
        fw.write("你好你好");
        fw.close();
    }
}
