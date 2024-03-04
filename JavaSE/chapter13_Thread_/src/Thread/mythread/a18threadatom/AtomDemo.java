package Thread.mythread.a18threadatom;

/**
 * @author ryanw
 */
public class AtomDemo {
    public static void main(String[] args) {

    }
}


class MyAtomThread implements Runnable {
    // 送冰淇淋的数量
    private volatile int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

        }
    }
}