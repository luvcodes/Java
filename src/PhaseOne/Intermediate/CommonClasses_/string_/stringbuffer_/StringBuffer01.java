package PhaseOne.Intermediate.CommonClasses_.string_.stringbuffer_;

public class StringBuffer01 {
    public static void main(String[] args) {
        /**
         * 1. StringBuffer的直接父类 是 AbstractStringBuilder
         * 2. StringBuffer 实现了 Serializable，即StringBuffer的对象可以串行化
         * 3. 在父类中 AbstractStringBuilder 有属性 char[] value, 不是final
         *    该value数组存放字符串内容，引出存放在堆中的
         * 4. StringBuffer是一个final类，不能被继承
         * 5. 因为StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)
         *    不用每次都更换地址(即不用每次创建新对象)，所以效率高于String
         * */
        StringBuffer stringBuffer = new StringBuffer("hello");

    }
}
