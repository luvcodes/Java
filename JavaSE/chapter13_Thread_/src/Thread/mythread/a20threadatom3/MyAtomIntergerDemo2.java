package Thread.mythread.a20threadatom3;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomIntergerDemo2 {
    // int get(): 获取值
    // int getAndIncrement(): 以原子方式将当前值加1，注意，这里返回的是自增前的值。
    // int incrementAndGet(): 以原子方式将当前值加1，注意，这里返回的是自增后的值。
    // int addAndGet(int data): 以原子方式将参数与对象中的值相加，并返回结果。
    // int getAndSet(int value): 以原子方式设置为newValue的值，并返回旧值。
    public static void main(String[] args) {
        // AtomicInteger ac1 = new AtomicInteger(10);
        // System.out.println(ac1.get());

        // AtomicInteger ac2 = new AtomicInteger(10);
        // int andIncrement = ac2.getAndIncrement();
        // System.out.println(andIncrement);
        // System.out.println(ac2.get());

        // AtomicInteger ac3 = new AtomicInteger(10);
        // int i = ac3.incrementAndGet();
        // System.out.println(i);//自增后的值
        // System.out.println(ac3.get());

        // AtomicInteger ac4 = new AtomicInteger(10);
        // int i = ac4.addAndGet(20);
        // System.out.println(i);
        // System.out.println(ac4.get());

        AtomicInteger ac5 = new AtomicInteger(100);
        int andSet = ac5.getAndSet(20);
        System.out.println(andSet);
        System.out.println(ac5.get());
    }
}
