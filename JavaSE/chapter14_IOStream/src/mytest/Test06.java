package mytest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test06 {
    public static void main(String[] args) throws IOException {
        // 使用字符缓冲流
        /*
         * 需求：把《出师表》的文章顺序进行恢复到一个新文件中。
         * 每一个文本前面都是有一个序号的，要进行排序。
         */
        // 1. 读取数据
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/mytest/csb.txt"));
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            // System.out.println(line);
            arrayList.add(line); // 把数据添加到集合中。
        }

        bufferedReader.close();

        // 2. 排序
        // 排序规则: 按照每一行前面的序号进行排列
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 获取o1和o2的序号
                int i1 = Integer.parseInt(o1.split("\\.")[0]);
                int i2 = Integer.parseInt(o2.split("\\.")[0]);
                return i1 - i2; // 升序排列，如果需要降序排列，可以使用i2 - i1;
            }
        });

        // 3. 写出
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/mytest/csbResult.txt"));
        for (String str : arrayList) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
