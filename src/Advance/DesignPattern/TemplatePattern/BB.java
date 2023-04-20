package Advance.DesignPattern.TemplatePattern;

public class BB {
    public void calculateTime() {
        // 得到开始的时间
        long start = System.currentTimeMillis();
        job();
        // 得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("AA 执行时间: " + (end - start));
    }

    public void job() {
        long num = 0;
        for (int i = 0; i <= 80000; i++) {
            num *= i;
        }
    }
}
