package Thread.mythread.a13waitandnotify;


/**
 * @author ryanw
 */
public class ThreadDemo {
    public static void main(String[] args) {
       /*
       *    需求：完成生产者和消费者（等待唤醒机制）的代码
       *         实现线程轮流交替执行的效果
       * */

        //创建线程的对象
        Cook c = new Cook();
        Foodie f = new Foodie();

        //给线程设置名字
        c.setName("厨师");
        f.setName("吃货");

        //开启线程
        c.start();
        f.start();
    }
}