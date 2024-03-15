package List_4.ArrayList_;

import java.util.ArrayList;

/**
 * @author yangrunze
 */
public class ArrayListDemo03 {
    public static void main(String[] args) {
        //1.创建集合对象
        ArrayList<String> list = new ArrayList<>();

        //2.添加元素
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        //3.遍历
        //快捷键:
        // list.fori 正向遍历
        // list.forr 倒着遍历
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            // i 依次表示集合里面的每一个索引
            if(i == list.size() - 1){
                //最大索引
                System.out.print(list.get(i));
            }else{
                //非最大索引
                System.out.print(list.get(i) + ", ");
            }
        }
        System.out.print("]");
    }
}
