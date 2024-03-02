package mytest;

import java.io.*;


/**
 * @author ryanw
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        /*
         * 实现一个验证程序运行次数的小程序，要求如下：
         * 1.当程序运行超过3次时给出提示:本软件只能免费使用3次,欢迎您注册会员后继续使用~
         * 2.程序运行演示如下:
         * 第一次运行控制台输出: 欢迎使用本软件,第1次使用免费~
         * 第二次运行控制台输出: 欢迎使用本软件,第2次使用免费~
         * 第三次运行控制台输出: 欢迎使用本软件,第3次使用免费~
         * 第四次及之后运行控制台输出: 本软件只能免费使用3次,欢迎您注册会员后继续使用~
         */

        // 原则：
        // IO：随用随创建
        // 什么时候不用什么时候关闭

        // 1.把文件中的数字读取到内存中
        BufferedReader br = new BufferedReader(new FileReader("src\\mytest\\count.txt"));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        // 当前软件又运行了依次
        count++;

        // 2. 判断
        // <= 3 正常运行
        // > 3 提示不能运行
        if (count <= 3) {
            System.out.println("欢迎使用本软件,第" + count + "次使用免费~");
        } else {
            System.out.println("本软件只能免费使用3次,欢迎您注册会员后继续使用~");
        }

        // 3. 把当前自增之后的count还要写出到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\mytest\\count.txt"));
        // 这里如果不写""转换成字符串，真正写到文件中的是这个数字在字符集当中所对应的字符。
        bw.write(count + "");
        bw.close();
    }
}
