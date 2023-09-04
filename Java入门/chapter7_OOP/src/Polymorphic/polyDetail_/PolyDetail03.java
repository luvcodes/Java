package Polymorphic.polyDetail_;

public class PolyDetail03 {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb instanceof BB);// true
        System.out.println(bb instanceof AA);// true

        // 向下转型
        // 两个都是true说明: 判断的是aa的运行类型是否为后面这个类型
        // 或者是后面这个类型的子类型
        AA aa = new BB();
        System.out.println(aa instanceof AA);
        System.out.println(aa instanceof BB);

        Object obj = new Object();
        System.out.println(obj instanceof AA);//false
        String str = "hello";
        //System.out.println(str instanceof AA);
        System.out.println(str instanceof Object);//true
    }
}


class AA {
}

class BB extends AA {
}
