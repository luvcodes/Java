package Advance.final_;

public class FinalDetail01 {
    public static void main(String[] args) {

    }
}

class AA {
    /**
     * 1. 定义时: 如public final double TAX_RATE = 0.08;
     * 2. 在构造器中
     * 3. 在代码块中
     * */
    public final double TAX_RATE = 0.08; // 1. 定义时赋值
    public final double TAX_RATE2;
    public final double TAX_RATE3;
    public AA() { // 构造器中赋值
        TAX_RATE2 = 0.09;
    }

    { // 在代码块赋值
        TAX_RATE3 = 8.8;
    }
}
