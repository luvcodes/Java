package Thread.ThreadUse_1.Method2_;

/**
 * @author ryanw
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 获取当前线程的对象
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + " hello world");
        }
    }
}
