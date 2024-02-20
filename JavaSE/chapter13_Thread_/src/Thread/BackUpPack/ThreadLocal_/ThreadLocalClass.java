package Thread.BackUpPack.ThreadLocal_;

/**
 * @author ryanw
 */
public class ThreadLocalClass {
    // 创建一个 Integer 类型的 ThreadLocal 实例，并提供初始值
    public static final ThreadLocal threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
       Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        });

       Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
       });

       thread1.start();
       thread2.start();

    }
}
