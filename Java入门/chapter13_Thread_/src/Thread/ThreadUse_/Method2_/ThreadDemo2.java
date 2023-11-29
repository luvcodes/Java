package Thread.ThreadUse_.Method2_;

public class ThreadDemo2 {
    public static void main(String[] args) {
        // 创建MyThreadDemo2对象表示多线程要执行的任务
        MyThread2 mt = new MyThread2();
        // 创建线程对象
        Thread t = new Thread(mt);
        Thread t2 = new Thread(mt);
        // 给线程设置名字
        t.setName("t");
        t2.setName("t2");
        // 开启线程
        t.start();
        t2.start();
    }
}
