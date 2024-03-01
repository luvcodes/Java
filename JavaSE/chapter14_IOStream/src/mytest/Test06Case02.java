package mytest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Test06Case02 {
    public static void main(String[] args) throws IOException {
            /*
                需求：把《出师表》的文章顺序进行恢复到一个新文件中。
            */


        //1.读取数据
        BufferedReader br = new BufferedReader(new FileReader("myio\\csb.txt"));
        String line;
        TreeMap<Integer,String> tm = new TreeMap<>();
        while((line = br.readLine()) != null){
            String[] arr = line.split("\\.");
            //0：序号  1 ：内容
            tm.put(Integer.parseInt(arr[0]),line);
        }
        br.close();


        //2.写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\result2.txt"));
        Set<Map.Entry<Integer, String>> entries = tm.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            String value = entry.getValue();
            bw.write(value);
            bw.newLine();
        }
        bw.close();


    }
}
