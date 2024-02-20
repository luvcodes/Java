package Thread.mythread.a13waitandnotify;

/**
 * @author ryanw
 */
public class Foodie extends Thread{

    @Override
    public void run() {
        /*
        * 1. 循环
        * 2. 同步代码块
        * 3. 判断共享数据是否到了末尾（到了末尾）
        * 4. 判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
        * */

        while(true){
            synchronized (Desk.lock){
                if (Desk.count == 0) {
                    break;
                } else {
                    // 先判断桌子上是否有面条
                    if(Desk.foodFlag == 0){
                        //如果没有，就等待
                        try {
                            // 让当前线程跟锁进行绑定
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        //把吃的总数-1
                        Desk.count--;
                        //如果有，就开吃
                        System.out.println("吃货在吃面条，还能再吃" + Desk.count + "碗！！！");
                        //吃完之后，唤醒厨师继续做
                        Desk.lock.notifyAll();
                        //修改桌子的状态
                        Desk.foodFlag = 0;
                    }
                }
            }
        }
    }
}
