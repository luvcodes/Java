package mytest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Test04 {
    public static void main(String[] args) throws IOException {
        /*
         * 文本文件中有以下的数据：
         * 2-1-9-4-7-8
         * 将文件中的数据进行排序，变成以下的数据：
         * 1-2-4-7-8-9
         */
        // 1. 读取数据
        FileReader fr = new FileReader("src/mytest/a.txt");
        // 读取数据拼接到StringBuilder当中
        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = fr.read()) != -1) {
            stringBuilder.append((char) ch);
        }

        fr.close();
        System.out.println(stringBuilder);

        // 2. 排序
        Integer[] arr = Arrays.stream(
            stringBuilder
            .toString()
            .split("-"))
            .map(Integer::parseInt)
            .sorted()
            .toArray(Integer[]::new);
        
        // 3. 写出
        FileWriter fileWriter = new FileWriter("src/mytest/a.txt");
        String s = Arrays.toString(arr).replace(", ", "-");
        String result = s.substring(1, s.length() - 1);
        fileWriter.write(result);
        fileWriter.close();
    }
}
