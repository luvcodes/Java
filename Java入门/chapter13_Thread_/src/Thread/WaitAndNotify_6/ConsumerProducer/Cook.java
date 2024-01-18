package Thread.WaitAndNotify_6.ConsumerProducer;

/**
 * @author ryanw
 */
public class Cook extends Thread {
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

