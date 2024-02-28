package mycharstream1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ryanw
 */
public class CharStreamDemo4 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\mycharstream1\\b.txt");
        fr.read();//会把文件中的数据放到缓冲区当中

        //清空文件
        FileWriter fw = new FileWriter("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\mycharstream1\\b.txt");

        //请问，如果我再次使用fr进行读取
        //会读取到数据吗？

        //会把缓冲区中的数据全部读取完毕

        //正确答案：
        //但是只能读取缓冲区中的数据，文件中剩余的数据无法再次读取
        int ch;
        while((ch = fr.read()) != -1){
            System.out.println((char)ch);
        }


        fw.close();
        fr.close();


    }
}
