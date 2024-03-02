package mycharstream04;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ryanw
 */
public class CharStreamDemo5 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src/mycharstream04/a.txt");

        // 写出数据，通过flush
        fw.write('刷'); // 写出第1个字符
        fw.flush();
        fw.write('新'); // 继续写出第2个字符，写出成功
        fw.flush();

        // 写出数据，通过close
        fw.write('关'); // 写出第1个字符
        fw.close();
//        fw.write('闭'); // 继续写出第2个字符,【报错】java.io.IOException: Stream closed
//        fw.close();

    }
}
