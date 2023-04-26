package PhaseOne.Intermediate.string_;

public class StringMethod {
    public static void main(String[] args) {
        
        String username = "johN";
        if ("john".equalsIgnoreCase(username)) {
            System.out.println("Success!");
        }
        else {
            System.out.println("Failure!");
        }

        // 3. length 获取字符的个数，字符串的长度
        System.out.println("Mark".length());
        // 4. indexOf 获取字符在字符串对象中第一次出现的索引，索引从0开始，如果找不到，返回-1
        String s1 = "wer@terwe@g@";
        int index = s1.indexOf('@');
        System.out.println(index);
        // 5. lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从0开始，如果找不到，返回-1
        s1 = "wer@terwe@g@";
        index = s1.lastIndexOf('@');
        System.out.println(index); // 11
        // 6. substring 截取指定范围的子串
        String name = "hello, Mark";
        System.out.println(name.substring(6)); // 截取后面的字符
        System.out.println(name.substring(0, 5));
    }
}
