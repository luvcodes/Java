package Thread;

/**
 * 使用多线程，模拟三个窗口同时售票100张
 * */
public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();

//        // 这里会出现票数超卖的现象
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
//class SellTicket01 extends Thread {
//    // 让多个线程共享ticketNum，所以定义成static
//    private static int ticketNum = 100;
//
//
//    @Override
//    public void run() {
//        while (true) {
//            if (ticketNum <= 0) {
//                System.out.println("Selling end...");
//                break;
//            }
//
//            // 休眠50毫秒
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
//            + " 剩余票数 = " + (--ticketNum));
//        }
//    }
//}

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