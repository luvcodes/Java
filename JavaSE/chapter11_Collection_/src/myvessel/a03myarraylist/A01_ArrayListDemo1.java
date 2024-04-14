package myvessel.a03myarraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ryanw
 */
public class A01_ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
    }
}
