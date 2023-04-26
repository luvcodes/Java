package PhaseOne.Intermediate.string_.Exercise;

public class StringExercise07 {
    public static void main(String[] args) {
        String a = "hello" + "abc";
        // 创建了几个对象?
        /**
         * 编译器会对上面这条语句优化，等价于String a = "helloabc";
         * 只创建了一个对象
         */
    }
}
