package PhaseOne.Intermediate.CommonClasses_.Wrapper_1;

public class Integer_2 {
    public static void main(String[] args) {
        // int <-> Integer 的装箱和拆箱

        // 手动装箱 int -> Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        // 手动拆箱 Integer -> int
        int i = integer.intValue();

        // jdk5以后，就可以自动装箱和拆箱了
        // 自动装箱 int -> Integer
        int n2 = 200;
        Integer integer2 = n2; // 底层使用的是 Integer.valueOf(n2)
        // 自动拆箱 Integer -> int
        int n3 = integer2; // 底层使用的是intValue() 方法
    }
}
