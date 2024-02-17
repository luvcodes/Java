package Wrapper_1;

public class WrapperExercise03 {
    public static void main(String[] args) {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);

        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);

        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);

        /**
         * i9 是由缓存获得的127的实例，因为127是在-128到127的范围内。
         * 而 i10 是通过new关键字明确创建的新对象。
         * 因此，i9 和 i10 引用了两个不同的对象，即使它们的值是相同的。所以，i9 == i10 返回 false。
         * */
        Integer i9 = 127;
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);

        /**
         * 当我们使用==运算符比较一个Integer对象和一个int基本类型时，Integer对象会自动拆箱成基本数据类型。
         * 因此，上述比较实际上是在比较两个基本数据类型的值，而这两个值都是127，所以它们是相等的。
         * */
        Integer i11 = 127;
        int i12 = 127;
        System.out.println(i11 == i12); // 只要有基本数据类型，就是在判断值是否相等

        /**
         * 与前面的情况相似，i13 会被自动拆箱成基本数据类型，然后与 i14 进行比较。
         * 因为它们的值都是128，所以它们是相等的。
         * */
        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14); // 只要有基本数据类型，等于就是在判断值是否相等
    }
}
