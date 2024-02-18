package com.itheima.a01jdk7datedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class A05_SimpleDateFormatDemo3 {
    public static void main(String[] args) throws ParseException {
        /* 需求:
            秒杀活动开始时间:2023年11月11日 0:0:0(毫秒值)
            秒杀活动结束时间:2023年11月11日 0:10:0(毫秒值)

            小贾下单并付款的时间为:2023年11月11日 0:01:0
            小皮下单并付款的时间为:2023年11月11日 0:11:0
            用代码说明这两位同学有没有参加上秒杀活动?
         */

        //1.定义字符串表示三个时间
        String startstr = "2023年11月11日 0:0:0";
        String endstr = "2023年11月11日 0:10:0";
        String orderstr = "2023年11月11日 0:01:00";
        //2.解析上面的三个时间，得到Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        Date startDate = sdf.parse(startstr);
        Date endDate = sdf.parse(endstr);
        Date orderDate = sdf.parse(orderstr);

        //3.得到三个时间的毫秒值
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long orderTime = orderDate.getTime();

        //4.判断
        if (orderTime >= startTime && orderTime <= endTime) {
            System.out.println("参加秒杀活动成功");
        } else {
            System.out.println("参加秒杀活动失败");
        }


    }
}
