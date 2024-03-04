package Thread.mythread.a21threadatom4;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomThread implements Runnable {
    // private volatile int count = 0; //送冰淇淋的数量
    // private Object lock = new Object();
    AtomicInteger ac = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 1,从共享数据中读取数据到本线程栈中.
            // 2,修改本线程栈中变量副本的值
            // 3,会把本线程栈中变量副本的值赋值给共享数据.
            // synchronized (lock) {
            // count++;
            // ac++;
            int count = ac.incrementAndGet();
            System.out.println("已经送了" + count + "个冰淇淋");
        }
    }
}
