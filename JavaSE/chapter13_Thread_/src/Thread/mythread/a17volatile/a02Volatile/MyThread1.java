package Thread.mythread.a17volatile.a02Volatile;

/**
 * @author ryanw
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        while(Money.money == 100000){

        }

        System.out.println("结婚基金已经不是十万了");
    }
}
