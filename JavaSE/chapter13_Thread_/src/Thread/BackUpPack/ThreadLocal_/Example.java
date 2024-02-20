package Thread.BackUpPack.ThreadLocal_;

/**
 * @author ryanw
 */
public class Example {
    // 创建一个 Integer 类型的 ThreadLocal 实例，并提供初始值
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(1);
                System.out.println("Thread 1: " + threadLocal.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(2);
                System.out.println("Thread 2: " + threadLocal.get());
            }
        });

        t1.start();
        t2.start();
    }
}
