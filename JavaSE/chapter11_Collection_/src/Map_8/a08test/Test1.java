package a08test;

import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
    public static void main(String[] args) {
       /* 班级里有N个学生，学生属性:姓名，年龄，性别。
        实现随机点名器。*/


        //1.定义集合
        ArrayList<String> list = new ArrayList<>();
        //2.添加数据
        Collections.addAll(list,"范闲","范建","范统","杜子腾","杜琦燕","宋合泛","侯笼藤","朱益群","朱穆朗玛峰","袁明媛");
        //3.随机点名
       /* Random r = new Random();
        int index = r.nextInt(list.size());
        String name = list.get(index);
        System.out.println(name);*/

        //打乱
        Collections.shuffle(list);

        String name = list.get(0);
        System.out.println(name);


    }
}
