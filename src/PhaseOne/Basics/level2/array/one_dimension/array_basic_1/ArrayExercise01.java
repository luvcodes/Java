package PhaseOne.Basics.level2.array.one_dimension.array_basic_1;

public class ArrayExercise01 {
    public static void main(String[] args) {
        /*
         * 创建一个char类型的26个元素的数组，'A' ~ 'Z'
         * 提示：char类型数据运算 'A' + 2 -> 'C'
         *
         * */
        char[] chars = new char[26];
        for (int i = 0; i < chars.length; i++) {
            // chars是char[]类型
            // chars[i]是char类型
            chars[i] = (char) ('A' + i); // 'A' + i是int类型，需要强制转换
        }
        // 打印
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}
