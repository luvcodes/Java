package Thread.mythread.a18threadatom;

/**
 * @author ryanw
 */
public class AtomDemo {
    public static void main(String[] args) {
        MyAtomThread myAtomThread = new MyAtomThread();
     
        for (int i = 0; i < 100; i++) {
            new Thread(myAtomThread).start();
        }
    }
}

class MyAtomThread implements Runnable {
    // 送冰淇淋的数量
    private volatile int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 1,从共享数据中读取数据到本线程栈中.
            // 2,修改本线程栈中变量副本的值
            // 3,会把本线程栈中变量副本的值赋值给共享数据.
            count++;
            System.out.println("已经送了" + count + "个冰淇淋");
        }
    }
}