package Thread.ThreadPool_7.Basics_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ryanw
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * public static ExecutorService newCachedThreadPool() 创建一个没有上限的线程池
         * public static ExecutorService newFixedThreadPool(int nThreads) 创建一个有上限的线程池，可以设置线程池的大小
         * */

        // 获取线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // 提交任务
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
//        // 销毁线程池
//        pool.shutdown();
    }
}
