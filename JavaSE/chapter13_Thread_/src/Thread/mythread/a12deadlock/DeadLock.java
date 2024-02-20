package Thread.mythread.a12deadlock;


/**
 * @author ryanw
 */
public class DeadLock {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("线程A");
        t2.setName("线程B");

        t1.start();
        t2.start();
    }
}