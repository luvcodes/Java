package a08test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
       /* 班级里有N个学生
        要求：
        70%的概率随机到男生
        30%的概率随机到女生

        "范闲","范建","范统","杜子腾","宋合泛","侯笼藤","朱益群","朱穆朗玛峰",
        "杜琦燕","袁明媛","李猜","田蜜蜜",
        */


        //1.创建集合
        ArrayList<Integer> list = new ArrayList<>();
        //2.添加数据
        Collections.addAll(list,1,1,1,1,1,1,1);
        Collections.addAll(list,0,0,0);
        //3.打乱集合中的数据
        Collections.shuffle(list);
        //4.从list集合中随机抽取0或者1
        Random r = new Random();
        int index = r.nextInt(list.size());
        int number = list.get(index);
        System.out.println(number);
        //5.创建两个集合分别存储男生和女生的名字
        ArrayList<String> boyList = new ArrayList<>();
        ArrayList<String> girlList = new ArrayList<>();

        Collections.addAll(boyList,"范闲","范建","范统","杜子腾","宋合泛","侯笼藤","朱益群","朱穆朗玛峰");
        Collections.addAll(girlList,"杜琦燕","袁明媛","李猜","田蜜蜜");

        //6.判断此时是从boyList里面抽取还是从girlList里面抽取
        if(number == 1){
            //boyList
            int boyIndex = r.nextInt(boyList.size());
            String name = boyList.get(boyIndex);
            System.out.println(name);
        }else{
            //girlList
            int girlIndex = r.nextInt(girlList.size());
            String name = girlList.get(girlIndex);
            System.out.println(name);
        }


    }
}
