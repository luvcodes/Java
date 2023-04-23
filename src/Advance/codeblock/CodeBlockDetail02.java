package Advance.codeblock;

public class CodeBlockDetail02 {
    public static void main(String[] args) {
        // getN1 -> static code block -> getN2 -> regular code block -> 构造器
        A a = new A(); // 因为getN1()在class中调用，所以是先getN1() 再是静态代码块
    }
}

class A {
    private int n2 = getN2(); // 普通属性初始化

    // 静态属性初始化
    private static int n1 = getN1();

    {
        System.out.println("A普通代码块01");
    }

    static {
        System.out.println("A静态代码块01");
    }

    public static int getN1() {
        System.out.println("getN1被调用");
        return 100;
    }

    public int getN2() {
        System.out.println("getN2被调用");
        return 200;
    }

    public A() {
        System.out.println("A无参构造器");
    }
}