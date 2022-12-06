package Basics.level3.object;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == c);
        System.out.println(b == c);

        B bObj = a; // 这其实就是向上转型，子类的对象赋给B类的引用
        System.out.println(bObj == c);
    }
}
class B{}
class A extends B{}
