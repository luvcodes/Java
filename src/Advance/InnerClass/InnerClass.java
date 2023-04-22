package Advance.InnerClass;

public class InnerClass {
    public static void main(String[] args) {
        
    }
}


class Outer {
    private int n1 = 100;
    public Outer(int n1) {
        this.n1 = n1;
    }
    public void m1() {
        System.out.println("m1()");
    }
    {
        System.out.println("Code block...");
    }
    // 内部类
    class Inner {
        
    }
}