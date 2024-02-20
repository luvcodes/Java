package Thread.mythread.a07threadyield;

/**
 * @author ryanw
 */
public class MyThread extends Thread{
    // "飞机"  "坦克"
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + "@" + i);
            // 表示出让当前CPU的执行权
            Thread.yield();
        }
    }
}
