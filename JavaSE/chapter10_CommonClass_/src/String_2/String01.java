package String_2;

/**
 * @author ryanw
 */
public class String01 {
    public static void main(String[] args) {
        /**
         1. String对象用于保存字符串，也就是一组字符序列
         2. "jack"字符串常量，双引号括起的字符序列
         3. 字符串的字符使用Unicode字符编码，一个字符(不足分字母还是汉字)占两个字节
         4. String类有很多构造器，构造器的重载
         5. String类实现了接口 Serializable [String可以串行化: 可以在网络传输]
                         接口 Comparable [String 对象可以比较大小]
         6. String是final类，不能被其他的类继承
         7. String有属性 private final char value[]; 用于存放字符串内容
         8. 一定要注意: value是一个final类型，不可以修改(不可修改指的是value不能指向新的地址，但是单个字符内容是可以变化的)
        */
        String name = "jack";
        name = "tom";
        final char[] value = {'a', 'b', 'c'};
        char[] v2 = {'t', 'o', 'm'};
        value[0] = 'H';
        // value = v2; // 不可以修改 value地址
        System.out.println(value[0]);
    }
}
