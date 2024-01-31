package interface_.basics;

// Phone类实现UsbInterface
// 解读1. 即Phone类需要实现 UsbInterface接口 规定/声明的方法
public class Phone implements UsbInterface {
    @Override
    public void start() {
        System.out.println("Phone start working");
    }

    @Override
    public void stop() {
        System.out.println("Phone stop working");
    }
}
