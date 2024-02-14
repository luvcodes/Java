package CommonClasses_.Wrapper_1;

public class WrapperExercise02 {
    public static void main(String[] args) {
//        Integer i = new Integer(1);
//        Integer j = new Integer(1);
//        System.out.println(i == j); // False

        Integer m = 1; //  底层Integer.valueOf(1) -> 需要看源码
        Integer n = 1; // 底层Integer.valueOf(1) -> 需要看源码
//        System.out.println(m == n); // T
        // 所以这里主要是看范围 -128 ~ 127 就是直接返回
        /**
         * 1. 如果i在IntegerCache.low(-128) - IntegerCache.high(127), 就直接从数组返回
         * 2. 如果不在，-128 - 127，就直接new Integer(i)
         * public static Integer valueOf(int i) {
         *  if (i >= IntegerCache.low && i <= IntegerCache.high) {
         *      return IntegerCache.cache[i + (-IntegerCache.low)];
         *  }
         *  return new Integer(i);
         * }
         * */

//        Integer m = 128; //  底层Integer.valueOf(1) -> 需要看源码
//        Integer n = 128; // 底层Integer.valueOf(1) -> 需要看源码
//        System.out.println(m == n); // T
        /**
         * 意思就是说，如果 i 在 IntegerCache.low (-128) 和 IntegerCache.high (127) 之间，
         * 则从缓存中获取Integer对象。
         * 如果 i 超出这个范围，则创建一个新的Integer对象。
         * 128超出了-128到127的范围，所以对于每个赋值都会创建一个新的Integer对象。
         * 因此，m 和 n 会引用内存中的两个不同的Integer对象。
         * */


        // 否则，就new Integer(xx)
        Integer x = 128; // 底层Integer.valueOf(1)
        Integer y = 128; // 底层Integer.valueOf(1)
//        System.out.println(x == y); // F
    }
}
