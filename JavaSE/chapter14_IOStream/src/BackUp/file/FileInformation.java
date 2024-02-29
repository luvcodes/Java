package BackUp.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    //获取文件的信息~
    @Test
    public void info() {
        //先创建文件对象
        File file = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\Java入门\\chapter14_IOStream\\src\\backupDocs\\demo02\\news1.txt");
        //调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());
        //getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        // 一个汉字三个字节
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());//T
        System.out.println("是不是一个文件=" + file.isFile());//T
        System.out.println("是不是一个目录=" + file.isDirectory());//F
    }
}
