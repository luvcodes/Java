package PhaseOne.Advance.DesignPattern.TemplatePattern;

public class AA extends Template {

    // 计算任务
    // 1+...+100000
    @Override
    public void job() {
        long num = 0;
        for (int i = 0; i <= 100000; i++) {
            num += i;
        }

    }

    public void job2() {
        long num = 0;
        for (int i = 0; i <= 200000; i++) {
            num += i;
        }
    }

}
