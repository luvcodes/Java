package Basics.level3.object;

/**
 * 提高具有哈希结构的容器的效率
 * 两个引用，如果指向的是同一个对象，则哈希值一定是一样的
 * 两个引用，如果指向的是不同对象，则哈希值是不一样的
 * 哈希值主要根据地址号来的，不能完全将哈希值等价于地址
 * 见以下的案例演示
 * 后面在集合中hashCode如果需要的话，也会重写
 * */
public class HashCode {
    public static void main(String[] args) {
        AA aa1 = new AA();
        AA aa2 = new AA();
        AA aa3 = aa1;
        System.out.println("aa.hashCode() = " + aa1.hashCode());
        System.out.println("aa.hashCode() = " + aa2.hashCode());
        System.out.println("aa.hashCode() = " + aa3.hashCode());
    }
}

class AA {

}