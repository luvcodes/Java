package CommonClasses_.Calendar_7;

import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {
        /**
         * Calendar是一个抽象类，构造器是private
         * 可以通过getInstance() 来获取实例
         * 提供大量的方法和字段提供给程序员
         * Calendar没有提供对应的格式化的类，因此需要程序员自己组合显示
         * 如果我们需要按照24小时进制来获取时间，Calendar.HOUR == 改成 => HOUR_OF_DAY
         *
         * Calendar的问题:
         * 可变性: 日期和时间这样的类应该是不可变的
         * 偏移性: Date中的年份是从1900开始的，而月份都从0开始
         * 格式化: 只对Date游泳，对Calendar没用
         * */
        Calendar c = Calendar.getInstance();
        System.out.println("c = " + c);

        // 获取日历对象的某个日历字段
        System.out.println("Year: " + c.get(Calendar.YEAR));
        // why add 1? 因为Calendar返回月的时候，是按照0开始编号
        System.out.println("Month: " + c.get(Calendar.MONTH) + 1);
        System.out.println("Day of month: " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("Hour: " + c.get(Calendar.HOUR));
        System.out.println("Minute: " + c.get(Calendar.MINUTE));
        System.out.println("Second: " + c.get(Calendar.SECOND));

        // Calendar没有提供对应的格式化的类，因此需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "year " + (c.get(Calendar.MONTH) + 1) + "month " + c.get(Calendar.DAY_OF_MONTH) + "day. " + "Hours " + c.get(Calendar.HOUR_OF_DAY));
    }
}
