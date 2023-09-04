package DesignPattern.TemplatePattern;

public class BB extends Template{

    @Override
    public void job() { // 这里也去充血了Template的job方法
        long num = 0;
        for (int i = 0; i <= 100000; i++) {
            num *= i;
        }
    }
}
