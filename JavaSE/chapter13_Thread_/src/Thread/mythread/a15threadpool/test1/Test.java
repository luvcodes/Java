package Thread.mythread.a15threadpool.test1;

/**
 * @author ryanw
 */
public class Test {
    public static void main(String[] args) {
       /*
            一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
            要求:请用多线程模拟卖票过程并打印剩余电影票的数量
        */

        // 创建线程对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // 给线程设置名字
        t1.setName("窗口1");
        t2.setName("窗口2");

        // 开启线程
        t1.start();
        t2.start();
    }
}
