package Thread.BackUpPack.ThreadUse_1.Method3_;

import java.util.concurrent.Callable;

/**
 * @author ryanw
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // sum of 1 to 100
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}

