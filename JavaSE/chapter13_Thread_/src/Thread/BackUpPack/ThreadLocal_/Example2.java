package Thread.BackUpPack.ThreadLocal_;

public class Example2 {
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    private static class MyRunnable implements Runnable {
        private int value;

        public MyRunnable(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            threadLocal.set(value);
            System.out.println("Thread with value: " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(1));
        Thread t2 = new Thread(new MyRunnable(2));

        t1.start();
        t2.start();
    }
}
