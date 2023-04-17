package Basics.level1.ForceConvert;

public class ForceConver2 {
    public static void main(String[] args) {
        // 强转符号只针对最近的操作数有效，往往会使用小括号提升优先级
        // int x = (int) 10*3.5+6*1.5; // 编译错误：double -> int
        int x = (int) (10*3.5+6*1.5); // 用括号把运算式括起来就可以运行成功了
        System.out.println(x);

        char c1 = 100;
        int m = 100;
        // char c2 = m // 错误，int转换为char不行
        char c3 = (char) m;
        System.out.println(c3); // 输出的是ASCII码中100对应的字母，d字符
    }
}
