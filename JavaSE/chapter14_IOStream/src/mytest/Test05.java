package mytest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test05 {
    public static void main(String[] args) throws IOException {
        /*
         * 四种方式拷贝文件，并统计各自用时
         */
        long start = System.currentTimeMillis();
        // method01();
        // method02();
        // method03();
        method04();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0 + "秒");

    }

    // 字节流的基本流: 一次读写一个字节4,588,568,576字节
    public static void method01() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/mytest/aa.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("src/mytest/bb.txt");
        int bb;
        while ((bb = fileInputStream.read()) != -1) {
            fileOutputStream.write(bb);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    // 字节流的基本流: 一次读写一个字节数组
    public static void method02() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/mytest/aa.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("src/mytest/bb.txt");
        byte[] bytes = new byte[8192];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    // 缓存字节流: 一次读写一个字节 4,588,568,576 字节
    public static void method03() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/mytest/aa.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/mytest/bb.txt"));
        int bb;
        while ((bb = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(bb);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }

    // 缓存字节流: 一次读写一个字节数组
    public static void method04() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/mytest/aa.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/mytest/bb.txt"));
        byte[] bytes = new byte[8192];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }

        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}
