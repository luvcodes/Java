package Thread.mythread.a13waitandnotify;

/**
 * @author ryanw
 */
public class Desk {
    // 作用：控制生产者和消费者的执行

    // 是否有面条  0：没有面条  1：有面条
    public static int foodFlag = 0;

    // 总个数
    public static int count = 10;

    // 锁对象
    public static Object lock = new Object();


}
