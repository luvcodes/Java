package Thread.mythread.a12deadlock;


public class ThreadDemo {
    public static void main(String[] args) {
       /*
           需求：
                死锁
       */


        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("线程A");
        t2.setName("线程B");

        t1.start();
        t2.start();

    }
}