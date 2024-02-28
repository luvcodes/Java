package mycharstream1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ryanw
 */
public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
            第一步：创建对象
            public FileReader(File file)        创建字符输入流关联本地文件
            public FileReader(String pathname)  创建字符输入流关联本地文件

            第二步：读取数据
            public int read()                   读取数据，读到末尾返回-1
            public int read(char[] buffer)      读取多个数据，读到末尾返回-1

            第三步：释放资源
            public void close()                 释放资源/关流
        */

        FileReader fileReader = new FileReader("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\mycharstream1\\a.txt");
        char[] chars = new char[2];
        int len;
        while ((len = fileReader.read(chars)) != -1) {
            // 把数组中的数据变成字符串再进行打印
            System.out.print(new String(chars, 0, len));
        }
    }
}
