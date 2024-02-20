package Thread.BackUpPack.ThreadUse_1;

/**
 * @author ryanw
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象，可以当做线程使用
        Cat cat = new Cat();

        /**
            (1) 追源码 start方法
            public synchronized void start() {
                start0();
            }
            (2) start0() 是本地方法，是JVM调用, 底层是c/c++实现
                真正实现多线程的效果， 是start0(), 而不是 run
                private native void start0();
         */

        /**
         * 这一行代码实际上做了两件事：
         * 1. 它启动了一个新的线程。
         * 2. 在这个新线程中，它自动调用了 cat 对象的 run() 方法。
         * */
        // 启动线程
        cat.start();

        //run方法就是一个普通的方法, 如果不先执行start方法而直接执行run方法，就相当于没有真正的启动一个线程，
        // 就会把run方法执行完毕，才向下执行
        //cat.run();
        /**
         *  说明: 当main线程启动一个子线程 Thread-0, 主线程不会阻塞, 会继续执行。意思就是main线程不等thread-0执行完才执行
         *  而是继续执行。
         *  这时 主线程和子线程是交替执行..
         */
        System.out.println("主线程继续执行" + Thread.currentThread().getName());
        for(int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}


//1. 当一个类继承了 Thread 类， 该类就可以当做线程使用
//2. 我们会重写 run方法，写上自己的业务代码
//3. run Thread 类 实现了 Runnable 接口的run方法
class Cat extends Thread {
    int times = 0;
    //重写run方法，写自己的业务逻辑
    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵, 我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 80) {
                break;
            }
        }
    }
}
