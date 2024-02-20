package Thread.BackUpPack.ThreadSynchronize_5;

/**
 * @author ryanw
 */
public class SellTicket {
    public static void main(String[] args) {
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
    }
}

class SellTicket03 implements Runnable {
    private int ticketNum = 100;
    private boolean loop = true;
    Object object = new Object();


    // 1. 锁就不在this上了，是加在 SellTicket03.class。同步方法（静态的）的锁为当前类本身
    public synchronized static void m1() {}

    /**
     * 2. 如果在静态方法中，实现一个同步代码块, 就不能使用synchronized(this)了，因为静态方法中不能使用this。
     * 原因: this是一个指向当前对象的引用，它只能在非静态方法中使用。
     * 因为静态方法属于类而不是对象，它们在类加载时就已经存在了，所以没有this对象可用。
     * 还是因为同步方法（静态的）的锁为当前类本身
     */
    public static void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    /**
     * 1. public synchronized void sell() {} 就是一个同步方法, 在同一时刻，只能有一个线程来执行sell方法
     * 2. 这时锁在 this对象
     * 3. 也可以在代码块上写 synchronize, 同步代码块, 互斥锁还是在this对象
     * */
    public /*synchronized*/ void sell() {
        /**
         * 这里把this改成object依然可以运行的原因就在于
         * 同步方法(非静态)的锁可以是this，也可以是其他对象。
         * 那么在上面定义了Object object = new Object()，同时在main方法里定义的对象，是三个线程属于同一个实例对象，
         * 那么就是相当于object就是"其他对象" 替代了 "this"
         * */
        synchronized (/*this*/ object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 1 - 0 - -1  - -2
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}

// new SellTicket01().start();
// new SellTicket01().start();
// 两个对象是两个不同的this，所以相当于对象争夺的是不同的锁，所以这样是锁不住的，代码失效。
// 必须要保证this对象是大家共享的对象
class SellTicket01 extends Thread {
    private static final int ticketNum = 100;
    public void m1() {
        synchronized (this) {
            System.out.println("hello");
        }
    }
}