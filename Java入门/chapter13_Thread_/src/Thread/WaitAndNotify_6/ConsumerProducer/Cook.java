package Thread.WaitAndNotify_6.ConsumerProducer;

public class Cook extends Thread {
    /**
     * 1. Loop
     * 2. Synchronized code block
     * 3. Check shared data has reached to the end (Reached end)
     * 4. Check shared data has reached to the end (Haven't reached end, 执行核心逻辑)
     */
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                    if (Desk.count == 0) {
                        break;
                    } else {
                        if (Desk.foodFlag == 1) {
                            try {
                                Desk.lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            System.out.println("厨师做了一碗面条");
                            Desk.foodFlag = 1;
                            // 叫醒所有消费者开吃
                            Desk.lock.notifyAll();
                        }
                    }
                }
            }
        }
    }

