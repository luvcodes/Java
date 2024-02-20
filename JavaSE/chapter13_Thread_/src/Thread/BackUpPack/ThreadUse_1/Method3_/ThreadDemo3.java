package Thread.BackUpPack.ThreadUse_1.Method3_;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ryanw
 */
public class ThreadDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 表示多线程要执行的任务
        MyCallable myCallable = new MyCallable();
        // 管理多线程运行的结果
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        // 表示线程
        Thread t = new Thread(futureTask);

        t.start();

        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
