package file.a02test;

import java.io.File;

/**
 * @author ryanw
 */
public class Test2 {
    public static void main(String[] args) {
        /* 需求：定义一个方法找某一个文件夹中，是否有以avi结尾的电影。（暂时不需要考虑子文件夹）*/

        File file = new File("a01myfile\\aaa\\bbb");
        boolean b = haveAVI(file);
        System.out.println(b);
    }

    /*
    * 作用：用来找某一个文件夹中，是否有以avi结尾的电影
    * 形参：要查找的文件夹
    * 返回值：查找的结果  存在true  不存在false
    * */
    public static boolean haveAVI(File file) {// D:\\aaa
        // 1.进入aaa文件夹，而且要获取里面所有的内容
        File[] files = file.listFiles();
        // 检查files是否为null（确保不是一个不存在的目录或者IO错误）
        if (files != null) {
            // 2.遍历数组获取里面的每一个元素
            for (File f : files) {
                // f：依次表示aaa文件夹里面每一个文件或者文件夹的路径
                if (f.isFile() && f.getName().endsWith(".avi")) {
                    return true;
                }
            }
        }
        // 3.如果循环结束之后还没有找到，直接返回false
        return false;
    }
}
