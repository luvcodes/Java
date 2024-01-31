package Thread.ThreadUse_1.Method1_;

/**
 * @author ryanw
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "Hello World");
        }
    }
}
