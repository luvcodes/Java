package Thread.mythread.a09synchronized.a09threadsafe1;

/**
 * @author ryanw
 */
public class MyThread extends Thread {
    // 表示这个类所有的对象，都共享ticket数据 0 ~ 99
    static int ticket = 0;

    @Override
    public void run() {
        while (true) {
            // 同步代码块
            // 小括号中写锁对象，一定要是唯一的
            // 一般可以使用当前类的字节码文件，因为在同一个文件夹里只会有一个字节码文件，所以一定是唯一的
            synchronized (MyThread.class) {
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
