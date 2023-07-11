//package PhaseOne.Intermediate.bignum_;
//
//import java.math.BigInteger;
//
//public class BigInteger {
//    public static void main(String[] args) {
//        /**
//         * 当我们编程中，需要处理很大的整数，long 不够用
//         * 可以使用BigInteger的类来解决
//         */
//        BigInteger bigInteger = new BigInteger("123456789");
//        BigInteger bigInteger2 = new BigInteger("100");
//        System.out.println(bigInteger);
//
//        /**
//         * 1. 在对BigInteger进行加减乘除的时候，需要使用对应的方法，不能进行 + - * /
//         * 2. 可以创建一个 要操作的 BigInteger 然后进行相应操作
//         */
//        BigInteger add = bigInteger.add(bigInteger2);
//        System.out.println(add);
//        BigInteger subtract = bigInteger.subtract(bigInteger2);
//        System.out.println(subtract);
//        BigInteger multiply = bigInteger.multiply(bigInteger2);
//        System.out.println(multiply);
//        BigInteger divide = bigInteger.divide(bigInteger2);
//        System.out.println(divide);
//    }
//}
