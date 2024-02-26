package file.a01myfile;

import java.io.File;

/**
 * @author ryanw
 */
public class FileDemo2 {
    public static void main(String[] args) {
         /*
            public boolean isDirectory()        判断此路径名表示的File是否为文件夹
            public boolean isFile()             判断此路径名表示的File是否为文件
            public boolean exists()             判断此路径名表示的File是否存在
         */
        // 1. 对一个文件的路径进行判断
        File f1 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\file.a01myfile\\a.txt");
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println("--------------------------------------");


        // 2. 对一个文件夹的路径进行判断
        File f2 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\file.a01myfile\\");
        System.out.println(f2.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.exists());
        System.out.println("--------------------------------------");

        // 3. 对一个不存在的路径进行判断
        File f3 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\file.a01myfile\\c.txt");
        System.out.println(f3.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.exists());
    }
}
