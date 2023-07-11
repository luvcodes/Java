package PhaseOne.Basics.level1.AutoConvert;

public class AutoConvert {
    public static void main(String[] args) {
        // 自动类型转换
        int num = 'a'; // char -> int
        double d1 = 80; // int -> double
        System.out.println(num);
        System.out.println(d1);
    }
}

class A {
    public static void main(String[] args) {
        /**
         * 细节1
         * 有多种类型的数据混合运算时，系统首先将所有的数据转换成容量最大的那种数据类型，然后再进行计算。
         * */
        int n1 = 10;
        double d1 = n1 + 1.1;
        // float d1 = n1 + 1.1 错误，n1是int类型，1.1是double类型，所以n1 + 1.1会转换成double类型，不能把double类型赋值给float中
        // 因为double比int精度大
        float d2 = (float) (n1 + 1.1);
        float d3 = n1 + 1.1f;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        // 细节2
        // 当我们把精度(容量)大的数据类型赋值给精度(容量)小的数据类型时，就会报错，
        // 反之就会进行自动类型转换
        // int n2 = 1.1; // 错误 double -> int

        // 细节3
        // (byte, short)和char之间不发生自动转换
        // 当把具体数赋给byte时，先判断该数是否在byte范围内，如果是就可以接收
        byte b1 = 10; // 可以，byte范围-127 - 128
        int n2 = 1;
//        byte b2 = n2; // 这样是不可以的，因为是直接变量赋值，会直接判断类型，n2为int，精度比byte大，无法赋值
//        char c1 = b1; // 错误，byte不能直接自动转换为char
    }
}

class autoConvert2 {
    public static void main(String[] args) {
        // 细节4：byte，short，char 他们三者之间可以计算，在计算时首先转换为int类型
        byte b2 = 1;
        byte b3 = 2;
        short s1 = 1;
//        short s2 = b2 + s1; // 错误，b2 + s1 => int类型，short比int精度低，无法赋值
        int s2 = b2 + s1;
//        byte b4 = b2 + b3; // 错误，b2 + b3尽管两者都是byte，但是结果还是int，byte比int精度低，无法赋值

        // 细节5：boolean不参与转换
        boolean pass = true;
//        int num100 = pass; // boolean不参与类型的自动转换

        // 细节6：自动提升原则：表达式结果的类型自动提升为操作数中最大的类型
        byte b4 = 1;
        short s3 = 100;
        int num200 = 1;
        double num300 = 1.1;
        double num500 = b4 + s3 + num200 + num300; // 用精度最大的来接受，double
        System.out.println(num500);
    }
}
