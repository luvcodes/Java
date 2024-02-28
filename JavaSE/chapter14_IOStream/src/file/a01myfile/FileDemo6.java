package file.a01myfile;

import java.io.File;

/**
 * @author ryanw
 */
public class FileDemo6 {
    public static void main(String[] args) {
        //public File[] listFiles()       获取当前该路径下所有内容

        //1.创建File对象
        File f = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\file\\a01myfile");
        //2.listFiles方法
        //作用：获取a01myfile文件夹里面的所有内容，把所有的内容放到数组中返回
        File[] files = f.listFiles();
        for (File file : files) {
            //file依次表示a01myfile文件夹里面的每一个文件或者文件夹
            System.out.println(file);
        }
    }
}
