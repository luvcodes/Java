package Thread.mythread.a15threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
         * public static ExecutorService newCachedThreadPool() 创建一个没有上限的线程池
         * public static ExecutorService newFixedThreadPool (int nThreads) 创建有上限的线程池
         */

        // 1.获取线程池对象
        ExecutorService pool1 = Executors.newFixedThreadPool(3);

        // 2.提交任务
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());

        // 3.销毁线程池
        // pool1.shutdown();



        // // 1,创建一个默认的线程池对象.池子中默认是空的.默认最多可以容纳int类型的最大值.
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // // Executors --- 可以帮助我们创建线程池对象
        // // ExecutorService --- 可以帮助我们控制线程池

        // executorService.submit(() -> {
        // System.out.println(Thread.currentThread().getName() + "在执行了");
        // });

        // // Thread.sleep(2000);

        // executorService.submit(() -> {
        // System.out.println(Thread.currentThread().getName() + "在执行了");
        // });

        // executorService.shutdown();



        // // 参数不是初始值而是最大值
        // ExecutorService executorService = Executors.newFixedThreadPool(10);

        // ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
        // System.out.println(pool.getPoolSize());// 0

        // executorService.submit(() -> {
        //     System.out.println(Thread.currentThread().getName() + "在执行了");
        // });

        // executorService.submit(() -> {
        //     System.out.println(Thread.currentThread().getName() + "在执行了");
        // });

        // System.out.println(pool.getPoolSize());// 2
        // // executorService.shutdown();
    }
}
