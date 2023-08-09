package interface_.basics;

// 实现接口就是把接口的方法实现
public class Camera implements UsbInterface {
    @Override
    public void start() {
        System.out.println("Camera started");
    }

    @Override
    public void stop() {
        System.out.println("Camera stopped");
    }
}
