import java.util.ArrayList;

/**
 * @author yangrunze
 */
public class GenericsDemo5 {
    public static void main(String[] args) {
        /*
            泛型不具备继承性，但是数据具备继承性
        */

        //创建集合的对象
        ArrayList<Ye> list1 = new ArrayList<>();
        ArrayList<Fu> list2 = new ArrayList<>();
        ArrayList<Zi> list3 = new ArrayList<>();

        //调用method方法
        //method(list1);
        //method(list2);
        //method(list3);

        list1.add(new Ye());
        list1.add(new Fu());
        list1.add(new Zi());
    }

    /*
     * 此时，泛型里面写的是什么类型，那么只能传递什么类型的数据。
     * */
    public static void method(ArrayList<Ye> list) {

    }
}


