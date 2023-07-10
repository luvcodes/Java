package PhaseOne.Intermediate.CommonClasses_.Calendar_7;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDate {
    public static void main(String[] args) {
        /**
         * 第三代日期:
         * 1. 使用now() 返回表示当前日期时间的对象
         * */
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println("Year: " + ldt.getYear());
        System.out.println("Month: " + ldt.getMonth());
        System.out.println("Month: " + ldt.getMonthValue());
        System.out.println("Day: " + ldt.getDayOfMonth());
        System.out.println("Hour: " + ldt.getHour());
        System.out.println("Minute: " + ldt.getMinute());
        System.out.println("Second: " + ldt.getSecond());

//        LocalDate now = LocalDate.now(); // 可以获取年月日
//        LocalTime now2 = LocalTime.now(); // 获取到时分秒
    }
}
