package a01myfile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ryanw
 */
public class FileDemo3 {
     /*
        public long length()                返回文件的大小（字节数量）
        public String getAbsolutePath()     返回文件的绝对路径
        public String getPath()             返回定义文件时使用的路径
        public String getName()             返回文件的名称，带后缀
        public long lastModified()          返回文件的最后修改时间（时间毫秒值）
     */

    public static void main(String[] args) {
        // 1.length  返回文件的大小（字节数量）
        // 细节1：这个方法只能获取文件的大小，单位是字节
        // 如果单位我们要是M，G，可以不断的除以1024
        // 细节2：这个方法无法获取文件夹的大小
        // 如果我们要获取一个文件夹的大小，需要把这个文件夹里面所有的文件大小都累加在一起。
        File f1 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile\\b.txt");
        long len = f1.length();
        System.out.println(len);

        File f2 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile");
        long len2 = f2.length();
        System.out.println(len2);
        System.out.println("====================================");

        // 2. getAbsolutePath 返回文件的绝对路径
        File f3 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile\\b.txt");
        String path1 = f3.getAbsolutePath();
        System.out.println(path1);

        File f4 = new File("a01myfile\\b.txt");
        String path2 = f4.getAbsolutePath();
        System.out.println(path2);
        System.out.println("====================================");

        // 3. getPath 返回定义文件时使用的路径
        File f5 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile\\b.txt");
        String path3 = f5.getPath();
        System.out.println(path3);

        File f6 = new File("a01myfile\\b.txt");
        String path4 = f6.getPath();
        System.out.println(path4);
        System.out.println("====================================");

        // 4. getName 获取名字
        // 细节1：
        // a.txt:
        // a 文件名
        // txt 后缀名、扩展名
        // 细节2：
        // 文件夹：返回的就是文件夹的名字
        File f7 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile\\b.txt");
        String name1 = f7.getName();
        System.out.println(name1);

        File f8 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile");
        String name2 = f8.getName();
        System.out.println(name2);
        System.out.println("====================================");

        // 5.lastModified  返回文件的最后修改时间（时间毫秒值）
        File f9 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\a01myfile\\b.txt");
        long time = f9.lastModified();
        System.out.println(time);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(time);
        String formatted = simpleDateFormat.format(date);
        System.out.println(formatted);
    }
}
