package Thread.mythread.a09synchronized.a10threadsafe2;

/**
 * @author ryanw
 */
public class MyRunnable implements Runnable {
    // 使用实现Runnable接口方法，就不需要是static了
    // 原因: 使用继承Thread类的方法来实现类，这样就会出现在main方法中new多个Thread示例对象的情况
    // 又想要将ticket变量共享，所以就需要设置成static。
    // 可是这里使用的是实现Runnable接口的方法，在main方法中Runnable接口的实例对象只会创建一次，
    // 所以这里的ticket变量就不需要加static了。
    int ticket = 0;

    @Override
    public void run() {
        // 1.循环
        while (true) {
            // 2.同步代码块（同步方法）
            if (method()) {
                break;
            }
        }
    }

    // this
    private synchronized boolean method() {
        // 3.判断共享数据是否到了末尾
        // 如果到了末尾
        if (ticket == 100) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 4. 如果没有到末尾
            ticket++;
            System.out.println(Thread.currentThread().getName() + "在卖第" + ticket + "张票！！！");
        }
        return false;
    }
}
