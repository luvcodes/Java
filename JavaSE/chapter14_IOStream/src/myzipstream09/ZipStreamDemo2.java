package myzipstream09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author ryanw
 */
public class ZipStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
         * 压缩流
         * 需求：
         * 把 src/myzipstream09/a.txt 打包成一个压缩包
         */
        // 1. 创建File对象表示要压缩的文件
        File src = new File("src/myzipstream09/a.txt");
        // 2. 创建File对象表示压缩包的位置
        File dst = new File("src/myzipstream09");
        // 3. 调用方法用来压缩
        toZip(src, dst);
    }

    /*
     * 作用：压缩
     * 参数一：表示要压缩的文件
     * 参数二：表示压缩包的位置
     */
    public static void toZip(File src, File dst) throws IOException {
        // 1. 创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dst, "a.zip")));
        // 2.创建ZipEntry对象，表示压缩包里面的每一个文件和文件夹
        // 参数：压缩包里面的路径
        ZipEntry entry = new ZipEntry("aaa\\bbb\\a.txt");
        // 3. 把ZipEntry对象放到压缩包中
        zos.putNextEntry(entry);
        // 4. 把src文件中的数据写到压缩包当中
        FileInputStream fis = new FileInputStream(src);
        int b;
        while ((b = fis.read()) != -1) {
            zos.write(b);
        }
        zos.closeEntry();
        zos.close();
    }
}
