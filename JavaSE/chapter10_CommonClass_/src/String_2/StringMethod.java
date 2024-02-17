package String_2;

/**
 * @author ryanw
 */
public class StringMethod {
    public static void main(String[] args) {
        
        String username = "johN";
        if ("john".equalsIgnoreCase(username)) {
            System.out.println("Success!");
        }
        else {
            System.out.println("Failure!");
        }
//        // 3. length 获取字符的个数，字符串的长度
//        System.out.println("Mark".length());

//        // 4. indexOf 获取字符在字符串对象中第一次出现的索引，索引从0开始，如果找不到，返回-1
//        String s1 = "r@terwe@g@";
//        int index = s1.indexOf('@');
//        System.out.println(index);
//        System.out.println("weIndex = " + s1.indexOf("we"));

//        // 5. lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从0开始，如果找不到，返回-1
//        s1 = "wer@terwe@g@";
//        index = s1.lastIndexOf('@');
//        System.out.println(index); // 11
//        System.out.println("ter position = " + s1.lastIndexOf("ter"));

        // 6. substring 截取指定范围的子串
        String name = "hello, Mark";
        // 下面name.substring(6) 从索引6开始截取后面所有的内容
        System.out.println(name.substring(6));
        // name.substring(0, 5)表示从索引0开始截取，截取到索引5-1=4位置
        System.out.println(name.substring(2, 5));
    }
}
