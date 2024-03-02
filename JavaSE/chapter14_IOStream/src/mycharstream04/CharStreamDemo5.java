package mycharstream04;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ryanw
 */
public class CharStreamDemo5 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\mycharstream1\\a.txt");

        fw.write("我的同学各个都很厉害");
        fw.write("说话声音很好听");

        fw.flush();

        fw.write("都是人才");
        fw.write("超爱这里哟");

        fw.close();

        fw.write("B站");
    }
}
