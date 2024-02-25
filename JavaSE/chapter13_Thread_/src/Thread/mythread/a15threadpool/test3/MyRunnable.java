package Thread.mythread.a15threadpool.test3;
/**
 * @author ryanw
 */
public class MyRunnable implements Runnable {

    // 第二种方式实现多线程，测试类中MyRunnable只创建一次，所以不需要加static
    int number = 1;

    @Override
    public void run() {
        //1.循环
        while (true) {
            //2.同步代码块
            synchronized (MyRunnable.class) {
                //3.判断共享数据（已经到末尾）
                if (number > 100) {
                    break;
                } else {
                    //4.判断共享数据（没有到末尾）
                    if(number % 2 == 1){
                        System.out.println(Thread.currentThread().getName() + "打印数字" + number);
                    }
                    number++;
                }
            }
        }
    }
}
