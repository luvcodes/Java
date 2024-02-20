package Thread.mythread.a13waitandnotify;

/**
 * @author ryanw
 */
public class Cook extends Thread{

    @Override
    public void run() {
        /*
         * 1. 循环
         * 2. 同步代码块
         * 3. 判断共享数据是否到了末尾（到了末尾）
         * 4. 判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
         * */

        while (true){
            synchronized (Desk.lock){
                if(Desk.count == 0){
                    break;
                }else{
                    //判断桌子上是否有食物
                    if(Desk.foodFlag == 1){
                        //如果有，就等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        //如果没有，就制作食物
                        System.out.println("厨师做了一碗面条");
                        //修改桌子上的食物状态
                        Desk.foodFlag = 1;
                        //叫醒等待的消费者开吃
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
