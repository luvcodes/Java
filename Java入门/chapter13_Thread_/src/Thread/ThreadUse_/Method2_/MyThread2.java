package Thread.ThreadUse_.Method2_;

public class MyThread2 implements Runnable {
    @Override
    public void run() {
        // Implement the code of the thread
        // iterate 100 times of hello world
        for (int i = 0; i < 100; i++) {
            // 获取当前线程的对象
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + " hello world");
        }
    }
}
