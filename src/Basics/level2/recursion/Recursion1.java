package Basics.level2.recursion;

public class Recursion1
{
    public static void main(String[] args) {
        T t1 = new T();
//        t1.test(4); // n = 2, n = 3, n = 4
        int res = t1.factorial(5);
        System.out.println(res);
    }
}


class T {
    public void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    // 阶乘
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}