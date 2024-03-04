package Thread.mythread.a17myvolatile.a03Synchronized;

/**
 * @author ryanw
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Money.money = 90000;
    }
}
