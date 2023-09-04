package annotation_;

import java.util.ArrayList;
import java.util.List;
    
public class SuppressWarnings_ {
    public static void main(String[] args) {
        /**
         * 1. 当我们不希望看到这些警告的时候，可以使用 SuppressWarnings注解来抑制警告信息
         * 2. 在{""}中，可以写入你希望抑制(不显示)警告信息
         *
         * 4. 关于SuppressWarnings 作用范围是和它放置的位置相关
         *    比如@SuppressWarnings放置在main方法，那么抑制警告的范围就是 main
         *    通常我们可以放置具体的语句，方法，类
         * */
        @SuppressWarnings({"all"})
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i;
        System.out.println(list.get(1));
    }

    public void f1() {
//        @SuppressWarnings({"rawtypes"})
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i;
        System.out.println(list.get(1));
    }
}


