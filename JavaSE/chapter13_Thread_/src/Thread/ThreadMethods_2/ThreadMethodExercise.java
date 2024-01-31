package Thread.ThreadMethods_2;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 1. 主线程每隔1s，输出hi，一共10次
         * 2. 当输出到hi 5时，启动一个子线程(要求实现Runnable)，每隔1s输出hello，
         * 等该线程输出10次hello后，退出。
         * 3. 主线程继续输出hi，直到主线程退出。
         * */
        T3 t3 = new T3();
        Thread thread = new Thread(t3);

        for (int i = 1; i <= 10; i++) {
            System.out.println("hi" + i);
            if (i == 5) {
                thread.start();
                thread.join();
            }
            Thread.sleep(1000);
        }
    }
}

class T3 implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello");
            ++count;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (count == 10) {
                break;
            }
        }
    }
}
