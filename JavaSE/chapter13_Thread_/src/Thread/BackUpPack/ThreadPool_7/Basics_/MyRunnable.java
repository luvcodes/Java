package Thread.BackUpPack.ThreadPool_7.Basics_;

/**
 * @author ryanw
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " --- " + i);
        }
    }
}

class Demo{
    int x=1;

    int y;
    public static void main (String [] args) {

        int z=2;

        Demo t=new Demo();
        System.out.println(t.x + t.y + z);
    }
}
