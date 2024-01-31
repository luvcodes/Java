package Thread;

/**
 * 使用多线程，模拟三个窗口同时售票100张
 * */
public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();

        // 这里会出现票数超卖的现象
        /**
         * 创建了三个不同的SellTicket01实例，每个实例都有自己的ticketNum。
         * 由于ticketNum是静态的，这意味着它是所有实例共享的。
         * 然而，由于你创建了三个不同的实例，它们之间不共享ticketNum。
         * 当你启动这三个线程时，每个线程都会从自己的ticketNum中减去1，
         * 而不受其他线程的影响。
         * 这可能导致每个线程都卖出100张票，因为它们各自操作的是不同的ticketNum。
         * */
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

        System.out.println("=== 使用实现接口方式来售票 ===");
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start(); // 第一个线程 - 窗口
        new Thread(sellTicket02).start(); // 第二个线程 - 窗口
        new Thread(sellTicket02).start(); // 第三个线程 - 窗口
    }
}

// 使用Thread方式
class SellTicket01 extends Thread {
    // 让多个线程共享ticketNum，所以定义成static
    private static int ticketNum = 100;


    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("Selling end...");
                break;
            }

            // 休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
            + " 剩余票数 = " + (--ticketNum));
        }
    }
}

class SellTicket02 implements Runnable {
    private int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("Selling end...");
                break;
            }

            // 休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数 = " + (--ticketNum));
        }
    }
}