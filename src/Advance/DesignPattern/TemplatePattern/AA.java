package Advance.DesignPattern.TemplatePattern;

public class AA extends Template {
    public void calculateTime() {
        // 得到开始的时间
        long start = System.currentTimeMillis();
        job();
        // 得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("AA 执行时间: " +  (end - start));
    }

    public void job() {
        // 得到开始的时间
        long start = System.currentTimeMillis();

        long num = 0;
        for (int i = 0; i <= 100000; i++) {
            num += i;
        }

        // 得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("AA Execution time: " + (end - start));
    }

    public void job2() {
        // 得到开始的时间
        long start = System.currentTimeMillis(); 
        long num = 0;
        for (int i = 0; i <= 200000; i++) {
            num += i;
        }
        // 得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("AA Execution time: " + (end - start));
    }
    
}
