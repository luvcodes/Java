package PhaseOne.Basics.level2.class_object.method;

public class MethodDetail {
    public static void main(String[] args) {
        A a = new A();
        int[] res = a.getSumAndSub(1, 4);
        System.out.println("sum = " + res[0]);
        System.out.println("gap = " + res[1]);

        byte b1 = 1;
        byte b2 = 2;
        a.getSumAndSub(b1, b2); // byte -> int
//        a.getSumAndSub(1.1, 1.2); // double -> int, 高精度到低精度不行

        // 4. 方法定义时的参数是形式参数，方法调用时传入的参数是实际参数。
        // 实际参数和形式参数的类型要一致或兼容、个数、顺序必须一致

    }
}

class A {
    // 如何返回多个结果 - 返回数组
    public int[] getSumAndSub(int n1, int n2) {
        int[] resArr = new int[2];
        resArr[0] = n1 + n2;
        resArr[1] = n1 - n2;
        return resArr;
    }

    public double f1() {
        double d1 = 1.1;
        int n1 = 100;
        return n1; // 这样是可以的因为符合自动类型转换 int -> double
    }

    public int n1() {
        double d1 = 1.2;
//        return d1; // 这样就不可以，int的范围比double小，但是d1是double，所以不能自动类型转换
        return 0;
    }
}
