package Thread.mythread.a03threadcase3;

import java.util.concurrent.Callable;

/**
 * @author ryanw
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        //求1~100之间的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
