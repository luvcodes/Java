package Thread.BackUpPack.ThreadPool_7.CustomizeThreadPool_;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ryanw
 */
public class MyThreadPoolDemo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3, // 核心线程数量, 能小于0
                6, // 最大线程数量, 不能小于0，最大数量 >= 核心线程数量
                60, // 空闲线程最大存活时间 不能小于0
                TimeUnit.SECONDS, // 时间单位 用TimeUnit指定
                new ArrayBlockingQueue<>(3), // 阻塞队列, 不能为null
                Executors.defaultThreadFactory(), // 线程工厂 不能为null
                new ThreadPoolExecutor.AbortPolicy() // 阻塞策略 不能为null
        );

        // 下面就是submit提交线程池的任务
        // poolExecutor.submit(new MyRunnable());

    }
}
