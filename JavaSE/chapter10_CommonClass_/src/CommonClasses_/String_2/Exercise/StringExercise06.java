package CommonClasses_.String_2.Exercise;

public class StringExercise06 {
    public static void main(String[] args) {
        // 以下语句创建了几个对象？
        String s1 = "hello";
        s1 = "haha";
        /**
         * 创建了两个对象。
         * s1在字符串常量池中查找hello，没有就创建
         * 然后s1在字符串常量池中查找haha，没有就创建
         */
    }
}

