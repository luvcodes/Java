package CommonClasses_2.Homework;

public class Homework04 {
    public static void main(String[] args) {
        String str = "abcHsp U 1234";
        countStr(str);
    }

    /**
     * 输入字符串，判断立main有多少个大写字母，多少个小写字母，多少个数字
     * 思路分析
     * (1) 遍历字符串，如果 char 在 '0' ~ '9' 就是一个数字
     * (2) 如果 char 在'a' ~ 'z' 就是一个小写字母
     * (3) 如果 char 在 'A' ~ 'Z' 就是一个大写字母
     * (4) 使用三个变量来记录 统计结果
     * */
    public static void countStr(String str) {
        if (str == null) {
            System.out.println("Input cannot be null");
            return;
        }
        int strLen = str.length();
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int otherCount = 0;
        for (int i = 0; i < strLen; i++)  {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numCount++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCount++;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("There are " + numCount + " numbers");
        System.out.println("Lower-case letters are " + lowerCount);
        System.out.println("Upper-case letters are " + upperCount);
        System.out.println("Other letters are " + otherCount);
    }
}
