package a01myfile;

import java.io.File;

/**
 * @author ryanw
 */
public class FileDemo1 {
    /*
        public File(String pathname)                根据文件路径创建文件对象
        public File(String parent, String child)    根据父路径名字符串和子路径名字符串创建文件对象
        public File(File  parent, String child)     根据父路径对应文件对象和子路径名字符串创建文件对象

        \:转义字符
    */
    public static void main(String[] args) {
        // 1. 根据字符串表示的路径，变成File对象
        String str = "C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile\\a.txt";
        File file = new File(str);
        System.out.println(file);

        // 2. 根据父路径名字符串和子路径名字符串创建文件对象
        String parent = "C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile";
        String child = "a.txt";
        File file2 = new File(parent, child);
        System.out.println(file2);

        // 3. 把一个File表示的路径和String表示路径进行拼接
        File parent2 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile");
        String child2 ="a.txt";
        File file3 = new File(parent2, child2);
        System.out.println(file3);
    }
}
