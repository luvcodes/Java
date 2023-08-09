package codeblock;

public class CodeBlockDetail04 {
    public static void main(String[] args) {
        // (1) 进行类的加载
        // 1.1 先加载父类A02 
        // 1.2 再加载B02
        // (2) 创建对象
        // 2.1
        new B02();
    }
}

class A02 {


    private static int n1 = getVal01();

    static {
        System.out.println("A02 static code block");
    }

    // 普通代码块
    {
        System.out.println("A02 regular code block");
    }

    public int n3 = getVal02();

    public static int getVal01() {
        System.out.println("getVal01");
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02");
        return 20;
    }

    public A02() {
        // 隐藏
        // super();
        // 普通代码和普通属性
        System.out.println("A02 contructor");
    }
}

class B02 extends A02 {
    private static int n3 = getVal03();
    static {
        System.out.println("B02 static code block");
    }

    {
        System.out.println("B02 regular code block");
    }

    public int n4 = getVal04();

    public static int getVal03() {
        System.out.println("getVal03");
        return 10;
    }

    public int getVal04() {
        System.out.println("getVal04");
        return 10;
    }
    
    public B02() {
        // 隐藏了
        // super();
        // 普通代码块
        System.out.println("B02 constructor");
    }
}