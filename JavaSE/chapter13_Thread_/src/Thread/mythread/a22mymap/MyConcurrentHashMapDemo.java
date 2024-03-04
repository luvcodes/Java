package Thread.mythread.a22mymap;

import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>(100);

        Thread t1 = new Thread(() -> {
            // 这个线程在其run方法的Lambda表达式中遍历从0到24的整数，
            // 将每个整数转换为字符串后，作为键和值放入hm中。
            for (int i = 0; i < 25; i++) {
                hm.put(i + "", i + "");
            }
        });

        Thread t2 = new Thread(() -> {
            // t2线程遍历从25到50的整数，也将它们转换为字符串后，
            // 作为键和值放入hm中
            for (int i = 25; i < 51; i++) {
                hm.put(i + "", i + "");
            }
        });

        // 程将并发执行，向ConcurrentHashMap实例中添加元素
        t1.start();
        t2.start();

        System.out.println("----------------------------");
        // 为了t1和t2能把数据全部添加完毕
        Thread.sleep(1000);

        // 0-0 1-1 ..... 50- 50

        for (int i = 0; i < 51; i++) {
            System.out.println(hm.get(i + ""));
        } // 0 1 2 3 .... 50
    }
}
