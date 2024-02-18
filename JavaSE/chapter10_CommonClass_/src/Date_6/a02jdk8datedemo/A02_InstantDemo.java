package com.itheima.a02jdk8datedemo;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class A02_InstantDemo {
    public static void main(String[] args) {
        /*
            static Instant now() 获取当前时间的Instant对象(标准时间)
            static Instant ofXxxx(long epochMilli) 根据(秒/毫秒/纳秒)获取Instant对象
            ZonedDateTime atZone(ZoneIdzone) 指定时区
            boolean isxxx(Instant otherInstant) 判断系列的方法
            Instant minusXxx(long millisToSubtract) 减少时间系列的方法
            Instant plusXxx(long millisToSubtract) 增加时间系列的方法
        */
        //1.获取当前时间的Instant对象(标准时间)
        Instant now = Instant.now();
        System.out.println(now);

        //2.根据(秒/毫秒/纳秒)获取Instant对象
        Instant instant1 = Instant.ofEpochMilli(0L);
        System.out.println(instant1);//1970-01-01T00:00:00z

        Instant instant2 = Instant.ofEpochSecond(1L);
        System.out.println(instant2);//1970-01-01T00:00:01Z

        Instant instant3 = Instant.ofEpochSecond(1L, 1000000000L);
        System.out.println(instant3);//1970-01-01T00:00:027

        //3. 指定时区
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(time);


        //4.isXxx 判断
        Instant instant4=Instant.ofEpochMilli(0L);
        Instant instant5 =Instant.ofEpochMilli(1000L);

        //5.用于时间的判断
        //isBefore:判断调用者代表的时间是否在参数表示时间的前面
        boolean result1=instant4.isBefore(instant5);
        System.out.println(result1);//true

        //isAfter:判断调用者代表的时间是否在参数表示时间的后面
        boolean result2 = instant4.isAfter(instant5);
        System.out.println(result2);//false

        //6.Instant minusXxx(long millisToSubtract) 减少时间系列的方法
        Instant instant6 =Instant.ofEpochMilli(3000L);
        System.out.println(instant6);//1970-01-01T00:00:03Z

        Instant instant7 =instant6.minusSeconds(1);
        System.out.println(instant7);//1970-01-01T00:00:02Z






    }
}
