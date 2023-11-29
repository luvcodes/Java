package Thread.ThreadSynchronize_5;

public class SellTicket {
    public static void main(String[] args) {
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第1个线程-窗口
        new Thread(sellTicket03).start();//第2个线程-窗口
        new Thread(sellTicket03).start();//第3个线程-窗口
    }
}

//实现接口方式, 使用synchronized实现线程同步
class SellTicket03 implements Runnable {
    // 让多个线程共享 ticketNum, 那么就没有必要用static修饰了
    private int ticketNum = 100;
    //控制run方法变量
    private boolean loop = true;
    Object object = new Object();


    //同步方法（静态的）的锁为当前类本身
    /**
     * 1. public synchronized static void m1() {} 锁是加在 SellTicket03.class
     */
    public synchronized static void m1() {}

    /**
     * 2. 如果在静态方法中，实现一个同步代码块。
     * 就不能使用synchronized(this)了，因为静态方法中不能使用this。原因: 静态方法中不能使用this关键字。this是一个指向当前对象的引用，它只能在非静态方法中使用。
     * 因为静态方法属于类而不是对象，它们在类加载时就已经存在了，所以没有this对象可用。
     */
    public static void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    /**
     * 1. public synchronized void sell() {} 就是一个同步方法
     * 2. 这时锁在 this对象
     * 3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象
     * */
    //同步方法, 在同一时刻，只能有一个线程来执行sell方法
    public /*synchronized*/ void sell() {
        /**
         * 这里把this改成object依然可以运行的原因就在于
         * 同步方法(非静态)的锁可以是this，也可以是其他对象。
         * 那么在上面定义了Object object = new Object()，同时在main方法里定义的对象，是三个线程属于同一个对象，
         * 那么就是相当于object就是"其他对象" 替代了 "this"
         * */
        synchronized (/*this*/ object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();//sell方法是一个同步方法
        }
    }
}

//使用Thread方式
class SellTicket01 extends Thread {
    private static int ticketNum = 100;//让多个线程共享 ticketNum

    /**
     * 这样上锁是锁不住的
     * 因为在使用这种方式创建对象开线程的时候
     * new SellTicket01().start();
     * new SellTicket01().start();
     * 这样就形成了 this 分别指向了不同的对象
     * */
    public void m1() {
        synchronized (this) {
            System.out.println("hello");
        }
    }

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));

        }
    }
}


//实现接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));//1 - 0 - -1  - -2

        }
    }
}

