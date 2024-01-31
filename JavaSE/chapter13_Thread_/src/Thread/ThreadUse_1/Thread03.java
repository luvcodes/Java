package Thread.ThreadUse_1;

/**
 * main线程启动两个子线程
 * @author ryanw
 */
public class Thread03 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new T1());
        Thread thread2 = new Thread(new T2());
        thread1.start();//启动第1个线程
        thread2.start();//启动第2个线程
    }
}

class T1 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            //每隔1秒输出 “hello,world”,输出10次
            System.out.println("hello,world " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 10) {
                break;
            }
        }
    }
}

class T2 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        //每隔1秒输出 “hi”,输出5次
        while (true) {
            System.out.println("hi " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 5) {
                break;
            }
        }
    }
}
