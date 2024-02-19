package Thread.mythread.a01threadcase1;

/**
 * @author ryanw
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        //书写线程要执行代码
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "HelloWorld");
        }
    }
}
