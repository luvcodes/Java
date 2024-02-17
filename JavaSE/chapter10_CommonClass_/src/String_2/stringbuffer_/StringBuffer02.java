package String_2.stringbuffer_;

/**
 * @author ryanw
 */
public class StringBuffer02 {
    public static void main(String[] args) {
        // 构造器的使用:
        // 1. 创建一个 大小为16的 char[], 用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();

        // 2. 通过构造器指定 char[] 大小
        StringBuffer stringBuffer1 = new StringBuffer(100);

        // 3. 通过给一个String 创建 StringBuffer, char[] 大小就是str.length() + 16
        StringBuffer stringBuffer2 = new StringBuffer("hello");
    }
}
