package Thread.mythread.a17myvolatile.a03Synchronized;

/**
 * @author ryanw
 */
public class Money {
    public static Object lock = new Object();
    public static volatile int money = 10000;
}
