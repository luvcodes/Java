package Thread.BackUpPack.ThreadMethods_2;

/**
 * @author ryanw
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("老韩");
        //1
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();//启动子线程

        //主线程打印5 hi ,然后我就中断 子线程的休眠
        for(int i = 0; i < 5; i++) {
            // 每隔1秒钟打印一个hi
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        // 1
        System.out.println(t.getName() + " 线程的优先级 =" + t.getPriority());

        //当执行到这里，就会中断 t线程的休眠. 提前中断t线程的休眠，相当于那20秒还没有走完就直接被中断了
        t.interrupt();
        /**
         * 这样执行的顺序是:
         * 1. 运行t线程的第一个for循环
         * 2. 执行try模块，进入t线程的20秒休眠事件
         * 3. 输出主线程的5个hi
         * 4. 执行主线程的输出语句
         * 5. t线程对象调用interrupt方法，进入了t线程的catch模块
         * 6. 再执行t线程的第一个for循环
         * */
    }
}


class T extends Thread { //自定义的线程类
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                // 获取当前线程的名称
                System.out.println(Thread.currentThread().getName() + "  吃包子~~~~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(20000);//20秒
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt 方法时，就会catch 一个 异常, 可以加入自己的业务代码
                //InterruptedException 是捕获到一个中断异常.
                System.out.println(Thread.currentThread().getName() + "被 interrupt了");
            }
        }
    }
}
