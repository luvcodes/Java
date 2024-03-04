package Thread.mythread.a24mysemaphore;

public class MySemaphoreDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        
        for (int i = 0; i < 100; i++) {
            new Thread(mr).start();
        }
    }
}
