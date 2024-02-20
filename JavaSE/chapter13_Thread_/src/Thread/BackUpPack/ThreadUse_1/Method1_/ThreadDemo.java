package Thread.BackUpPack.ThreadUse_1.Method1_;

/**
 * @author ryanw
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // create two threads and the set the names
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
