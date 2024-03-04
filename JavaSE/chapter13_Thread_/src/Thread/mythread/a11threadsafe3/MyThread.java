package Thread.mythread.a11threadsafe3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ryanw
 */
public class MyThread extends Thread {
    static int ticket = 0;
    // static关键字证明所有的对象都共享同一把锁
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        //1.循环
        while(true){
            // 2. 加锁
            lock.lock();
            try {
                //3.判断
                if(ticket == 100){
                    break;
                    //4.判断
                }else{
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName() + "在卖第" + ticket + "张票！！！");
                }
                //  }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放锁，保证锁一定会被释放
                lock.unlock();
            }
        }
    }
}
