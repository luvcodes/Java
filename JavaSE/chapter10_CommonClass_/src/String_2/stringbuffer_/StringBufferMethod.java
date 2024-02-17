package String_2.stringbuffer_;

/**
 * @author ryanw
 */
public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello");
        // 增
        s.append(',');
        s.append("mark");
        s.append("Emma").append(100).append(true).append(10.5);
        System.out.println(s);

        // 删
        /**
         * 删除索引为>=start && < end处的字符
         * 删除11-14的字符 [11,14)
         * */
        s.delete(11, 14);
        System.out.println(s);

        // 改
        // 使用Andrew 替换 索引9-11的字符 [9,11)
        s.replace(9, 11, "周芷若");
        System.out.println(s);
        // 查找指定的字串在字符串第一次出现的索引，如果找不到返回-1
        int indexOf = s.indexOf("张三丰");
        // 6
        System.out.println(indexOf);

        // 插
        // 在索引为9的位置插入 "赵敏", 原来索引额外为9的内容自动后移
        s.insert(9, "赵敏");
        System.out.println(s);
    }
}
