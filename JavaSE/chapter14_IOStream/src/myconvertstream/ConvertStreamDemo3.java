package myconvertstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * @author ryanw
 */
public class ConvertStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
         * 将本地文件中的GBK文件，转成UTF-8
         */

         // 1. JDK 11以前的方案
        // InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/myconvertstream/b.txt"), "GBK");
        // OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("src/myconvertstream/d.txt"), "UTF-8");
        
        // int b;
        // while ((b = inputStreamReader.read()) != -1) {
        //     outputStreamWriter.write(b);
        // }

        // outputStreamWriter.close();
        // inputStreamReader.close();

        // 2. JDK 11以后的方案
        FileReader fileReader = new FileReader("src/myconvertstream/b.txt", Charset.forName("GBK"));
        FileWriter fileWriter = new FileWriter("src/myconvertstream/e.txt", Charset.forName("UTF-8"));
        
        int b;
        while ((b = fileReader.read()) != -1) {
            fileWriter.write(b);
        }

        fileWriter.close();
        fileReader.close();
    }
}
