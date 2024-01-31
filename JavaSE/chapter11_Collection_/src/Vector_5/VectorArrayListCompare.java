package Vector_5;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Vector;

/**
 * @author ryanw
 * 对比证明Vector和ArrayList的同步性的差异
 * Vector是同步的，ArrayList不是同步的
 */
public class VectorArrayListCompare {
    private static final int THREAD_COUNT = 100;
    private static Vector<Integer> vector = new Vector<>();
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        ThreadGroup vectorGroup = new ThreadGroup("VectorGroup");
        ThreadGroup arrayListGroup = new ThreadGroup("ArrayListGroup");

        // 有100个arraylist线程和100个vector线程, 每次每个线程分别加100个元素
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(vectorGroup, () -> {
                for (int j = 0; j < 100; j++) {
                    vector.add(j);
                    // 尝试在添加后立即遍历 Vector
                    vector.forEach(v -> {});
                }
            }).start();

            new Thread(arrayListGroup, () -> {
                for (int j = 0; j < 100; j++) {
                    arrayList.add(j);
                    // 尝试在添加后立即遍历 ArrayList
                    try {
                        arrayList.forEach(a -> {});
                    } catch (ConcurrentModificationException e) {
                        System.out.println("ArrayList is not thread-safe: " + e.getMessage());
                    }
                }
            }).start();
        }

        // 等待所有线程完成
        while (vectorGroup.activeCount() > 0 || arrayListGroup.activeCount() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Vector size: " + vector.size());
        System.out.println("ArrayList size: " + arrayList.size());
    }
}
