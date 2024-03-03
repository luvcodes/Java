package myzipstream09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 解压缩流
 **/
public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建一个File表示要解压的压缩包
        File src = new File("src/myzipstream09/aaa.zip");
        // 2. 创建一个File表示解压缩的目的地
        File dest = new File("src/myzipstream09/");
        // 3. 调用方法，解压缩包
        unzip(src, dest);
    }

    public static void unzip(File src, File dest) throws IOException {
        // 解压的本质：把压缩包里面的每一个文件或者文件夹读取出来，按照层级拷贝到目的地当中
        // 创建一个解压缩流用来读取压缩包中的数据
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));
        // 要先获取到压缩包里面的每一个zipentry对象, 表示当前在压缩包中获取到的文件或者文件夹
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            System.out.println(entry);
            if (entry.isDirectory()) {
                // 如果是文件夹，需要在目的地dest处创建一个同样的文件夹
                File file = new File(dest, entry.toString());
                file.mkdirs();
            } else {
                // 如果是文件，需要读取压缩包中的文件，并把它存放到目的地dest文件夹中，按照层级目录进行存放
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                int b;
                while ((b = zip.read()) != -1) {
                    // 写到目的地
                    fos.write(b);
                }
                fos.close();
                // 表示在压缩包中的一个文件处理完毕了
                zip.closeEntry(); // 关闭当前zipentry对象，表示当前文件处理完毕了，进入下一个文件处理
            }
        }

        zip.close(); // 关闭解压缩流
    }
}
