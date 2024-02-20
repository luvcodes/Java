package Thread.mythread.a09threadsafe1;

/**
 * @author ryanw
 */
public class MyThread extends Thread {

    // 表示这个类所有的对象，都共享ticket数据
    // 0 ~ 99
    static int ticket = 0;

    @Override
    public void run() {
            while (true) {
                synchronized (MyThread.class) {
                //同步代码块
                if (ticket < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票！！！");
                } else {
                    break;
                }
            }
        }
    }
}
