package ForLoop_.basics;

/**
 * for(int i = 1; i <= 10; i++){System.out.println("Hello World!};
 * 运行的方式是：
 * 第一步：i=1，i<=10，执行println
 * 第二步：跳到i++，i就等于2了，判断i是否小于等于10，如果条件满足，再执行println
 * 不断执行到i++以后i的值是10的时候，条件判断，通过，再执行一次println
 * 再跳到i++，现在i的值就是11了，条件判断，不满足，跳出循环。
 * */

public class For01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) { // (循环初始值;循环变量条件;循环变量迭代)
            System.out.println("Hello World!" + i);
        }
    }
}
