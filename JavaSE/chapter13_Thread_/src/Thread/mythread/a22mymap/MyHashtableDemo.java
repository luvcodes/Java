package Thread.mythread.a22mymap;

import java.util.Hashtable;

public class MyHashtableDemo {
    public static void main(String[] args) throws InterruptedException {
        Hashtable<String, String> hashtable = new Hashtable<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                hashtable.put(i + "", i + "");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 51; i++) {
                hashtable.put(i + "", i + "");
            }
        });

        t1.start();
        t2.start();

        System.out.println("---------------------------");
        // 为了t1和t2能把数据全部添加完毕
        Thread.sleep(1000);

        for (int i = 0; i < 51; i++) {
            System.out.println(hashtable.get(i + ""));
        }
    }
}
