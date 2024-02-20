package Thread.mythread.a06threadSetDaemon;

/**
 * @author ryanw
 */
public class ThreadDemo {
    public static void main(String[] args) {
       /*
            final void setDaemon(boolean on)    设置为守护线程
            细节：当其他的非守护线程执行完毕之后，守护线程会陆续结束
            通俗易懂：当女神线程结束了，那么备胎也没有存在的必要了
       */

        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("女神");
        t2.setName("备胎");

        //把第二个线程设置为守护线程（备胎线程）
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}
