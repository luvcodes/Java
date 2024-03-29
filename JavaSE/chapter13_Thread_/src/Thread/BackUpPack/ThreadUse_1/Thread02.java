package Thread.BackUpPack.ThreadUse_1;

/**
 * 通过实现接口Runnable 来开发线程
 * @author ryanw
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
//        dog.start(); // 这里不能调用start
        //创建了Thread对象，把 dog对象(实现Runnable),放入Thread
//        Thread thread = new Thread(dog);
//        thread.start();

//        // 实现了 Runnable接口
//        Tiger tiger = new Tiger();
//        // 能把tiger传进去，是因为Tiger类实现了Runnable接口
//        ThreadProxy threadProxy = new ThreadProxy(tiger);
//        threadProxy.start();
    }
}

class Animal {}

class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫....");
    }
}

//线程代理类, 模拟了一个极简的Thread类
//你可以把Proxy类当做 ThreadProxy
class ThreadProxy implements Runnable {
    //属性，类型是 Runnable
    private Runnable target = null;

    @Override
    public void run() {
        if (target != null) {
            //动态绑定（运行类型Tiger）
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        // 这个方法是真正实现多线程方法
        start0();
    }

    public void start0() {
        run();
    }
}

// 通过实现Runnable接口，开发线程
class Dog implements Runnable {
    int count = 0;

    @Override
    public void run() { //普通方法
        while (true) {
            System.out.println("小狗汪汪叫..hi" + (++count) + Thread.currentThread().getName());

            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 输出10次
            if (count == 10) {
                break;
            }
        }
    }
}
