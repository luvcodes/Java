package reader_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author 韩顺平
 * @version 1.0
 * 演示bufferedReader 使用
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\ryanw\\IdeaProjects\\Java\\MyJava\\src\\PhaseOne\\Amatuer\\reader_\\practice_.test.txt";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取: 按行读取, 效率高
        String line;
        //说明
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流
        //FileReader。
        /*
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了.
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }

         */
        bufferedReader.close();

    }
}
