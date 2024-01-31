package Thread.WaitAndNotify_6.BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) {
        /**
         * 生产者和消费者必须使用同一个阻塞队列
         * */

        // 创建阻塞队列对象
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(1);

        // 创建线程的对象，并把阻塞队列传递进去
        Cook cook = new Cook(queue);
        Foodie foodie = new Foodie(queue);

        cook.start();
        foodie.start();
    }
}
