package Basics.level3.Super;

public class A extends Base {
//    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public A() {}
    public A(String name) {}
    public A(String name, int age) {}

    public void cal() {
        System.out.println("Class A's cal method...");
    }

    public void test100() {
        System.out.println("test100");
    }
    protected void test200() {
        System.out.println("test200");
    }
    void test300() {
        System.out.println("test300");
    }
    private void test400() {
        System.out.println("test400");
    }
}
