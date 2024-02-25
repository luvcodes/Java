package Thread.mythread.a15threadpool.test4case2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MyThread extends Thread{

    //总金额
    static BigDecimal money = BigDecimal.valueOf(100.0);
    //个数
    static int count = 3;
    //最小抽奖金额
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);

    @Override
    public void run() {
        synchronized (MyThread.class){
            if(count == 0){
                System.out.println(getName() + "没有抢到红包！");
            }else{
                //中奖金额
                BigDecimal prize;
                if(count == 1){
                    prize = money;
                }else{
                    //获取抽奖范围
                    double bounds = money.subtract(BigDecimal.valueOf(count-1).multiply(MIN)).doubleValue();
                    Random r = new Random();
                    //抽奖金额
                    prize = BigDecimal.valueOf(r.nextDouble());
                }
                //设置抽中红包，小数点保留两位，四舍五入
                prize = prize.setScale(2,RoundingMode.HALF_UP);
                //在总金额中去掉对应的钱
                money = money.subtract(prize);
                //红包少了一个
                count--;
                //输出红包信息
                System.out.println(getName() + "抽中了" + prize + "元");
            }
        }
    }
}
