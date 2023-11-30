package Thread.WaitAndNotify_6.ConsumerProducer;

public class Foodie extends Thread{
    /**
     * 1. Loop
     * 2. Synchronized code block
     * 3. Check shared data has reached to the end (Reached end)
     * 4. Check shared data has reached to the end (Haven't reached end, 执行核心逻辑)
     * */
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    // 先判断桌子上是否有面条
                    if (Desk.foodFlag == 0) {
                        // 如果没有 等待
                        try {
                            Desk.lock.wait(); // 让当前线程跟锁进行绑定
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 把吃的总数 - 1
                        Desk.count--;
                        // 如果有 开吃
                        System.out.println("吃货正在吃面条，还能再吃" + Desk.count + "碗");
                        // 吃完之后，唤醒厨师继续做。
                        Desk.lock.notifyAll();
                        // 修改桌子的状态 (foodFlag)
                        Desk.foodFlag = 0;
                    }
                }
            }
        }
    }
}
