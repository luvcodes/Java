package mytest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Test03 {
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
        String str = stringBuilder.toString();
        String[] arrStr = str.split("-");

        // 用一个ArrayList存储integer数据
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 得到每一个字符串
        for (String string : arrStr) {
            int i = Integer.parseInt(string);
            list.add(i);
        }
        System.out.println(list);

        // 对ArrayList进行排序
        Collections.sort(list);
        System.out.println(list);


        // 3. 写出数据
        FileWriter writer = new FileWriter("src/mytest/a.txt");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                writer.write(list.get(i) + "");
            } else {
                writer.write(list.get(i) + "-");
            }
        }

        writer.close();
    }
}
