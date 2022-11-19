package Basics.level2.VarParameter.Lecture;

/**
 * 细节：
 * 可变参数的实参可以为0个或任意多个
 * 可变参数的实参可以为数组
 * 可变参数的本质就是数组
 * 可变参数可以和普通类型的参数一起放在参数列表，但必须保证可变参数在最后
 * 一个形参列表只能出现一个可变参数
 * */
public class VarParameterDetail {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        T t = new T();
        t.f1(arr);
    }
}

class T {
    public void f1(int... nums) {
        System.out.println("长度 = " + nums.length);
    }

    // 可变参数可以和普通类型的参数一起放在参数列表，但必须保证可变参数在最后
    public void f2 (String str, double... nums) {

    }

    // 一个形参列表只能出现一个可变参数
    // 下面是错的
//    public void f3(int... nums1, double... nums2) {}
}
