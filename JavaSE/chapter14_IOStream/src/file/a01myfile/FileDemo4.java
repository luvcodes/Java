package file.a01myfile;

import java.io.File;
import java.io.IOException;

/**
 * @author ryanw
 */
public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        /*
        public boolean createNewFile()      创建一个新的空的文件
        public boolean mkdir()              创建单级文件夹
        public boolean mkdirs()             创建多级文件夹
      */

        //1.createNewFile 创建一个新的空的文件
        //细节1：如果当前路径表示的文件是不存在的，则创建成功，方法返回true
        //      如果当前路径表示的文件是存在的，则创建失败，方法返回false
        //细节2：如果父级路径是不存在的，那么方法会有异常IOException
        //细节3：createNewFile方法创建的一定是文件，如果路径中不包含后缀名，则创建一个没有后缀的文件
        /*File f1 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\file\\a01myfile");
        boolean b = f1.createNewFile();
        //true
        System.out.println(b);*/

        //2.mkdir   make Directory，文件夹（目录）
        //细节1：windows当中路径是唯一的，如果当前路径已经存在，则创建失败，返回false
        //细节2：mkdir方法只能创建单级文件夹，无法创建多级文件夹。
        /*File f2 = new File("D:\\aaa\\aaa\\bbb\\ccc");
        boolean b = f2.mkdir();
        System.out.println(b);*/

        //3.mkdirs   创建多级文件夹
        //细节：既可以创建单级的，又可以创建多级的文件夹
        File f3 = new File("D:\\aaa\\ggg");
        boolean b = f3.mkdirs();
        //true
        System.out.println(b);
    }
}
