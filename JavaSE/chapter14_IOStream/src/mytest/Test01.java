package mytest;

import java.io.*;

/**
 * @author ryanw
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        // 拷贝一个文件夹，考虑子文件夹
        File source = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\mytest");
        File destination = new File("C:\\Users\\ryanw\\IdeaProjects\\Java\\JavaSE\\chapter14_IOStream\\src\\mytest\\aaa");

        copyDirectory(source, destination);
    }

    /*
     * 作用：拷贝文件夹
     * 参数一：数据源
     * 参数二：目的地
     * */
    private static void copyDirectory(File source, File destination) throws IOException {
        destination.mkdirs();
        //递归
        //1.进入数据源
        File[] files = source.listFiles();
        // 2. 遍历数组
        for (File file : files) {
            if (file.isFile()) {
                // 3. 判断文件，拷贝
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(destination, file.getName()));
                byte[] bytes = new byte[1024];
                int len;

                while ((len = fileInputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }

                fileOutputStream.close();
                fileInputStream.close();
            } else {
                // 4. 判断文件夹，递归
                copyDirectory(file, new File(destination, file.getName()));
            }
        }
    }
}
