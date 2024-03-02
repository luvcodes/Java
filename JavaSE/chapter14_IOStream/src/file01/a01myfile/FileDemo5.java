package file01.a01myfile;

import java.io.File;

/**
 * @author ryanw
 */
public class FileDemo5 {
    public static void main(String[] args) {
      /*
        public boolean delete()             删除文件、空文件夹
        细节：
            如果删除的是文件，则直接删除，不走回收站。
            如果删除的是空文件夹，则直接删除，不走回收站
            如果删除的是有内容的文件夹，则删除失败
      */

        //1.创建File对象
        File f1 = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\file\\a01myfile\\a.txt");
        //2.删除
        boolean b = f1.delete();
        System.out.println(b);
    }
}
