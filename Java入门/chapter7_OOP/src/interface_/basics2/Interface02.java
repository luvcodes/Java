package interface_.basics2;

public class Interface02 {
    public static void main(String[] args) {
        A a = new A();
    }
}

// 1. 如果一个类implements一个接口 需要将该接口的所有抽象方法都实现
class A implements AInterface {
    public void hi() {
        System.out.println("Hi...");
    }
}
