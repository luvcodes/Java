package PhaseOne.Intermediate.Homework;

public class Homework03 {
    public static void main(String[] args) {
        String name = "Han shun Ping";
        printName(name);
    }

    /**
     * 编写方法: 完成输出格式要求的字符串
     * 输入形式为: Han shun Ping的人名，以Ping，Han .S的形式打印出来。其中.S是中间单词的首字母
     * 思路分析:
     * (1) 对输入的字符串进行 分割split(" ")
     * (2) 对得到的String[] 进行格式化String.format()
     * (3) 对输入的字符串进行校验即可
     * */
    public static void printName(String str) {
        if (str == null) {
            System.out.println("str cannot be empty");
            return;
        }

        String[] names = str.split(" ");
        if (names.length != 3) {
            System.out.println("Input string incorrect format!");
            return;
        }

        String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
