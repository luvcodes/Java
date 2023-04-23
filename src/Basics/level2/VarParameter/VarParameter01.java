package Basics.level2.VarParameter;
/**
 * java允许将同一个类中多个同名同功能但参数个数不同的方法，封装成一个方法。
 * 就可以通过可变参数实现
 * */
public class VarParameter01 {
    public static void main(String[] args) {
        HspMethod hspMethod = new HspMethod();
        System.out.println(hspMethod.sum(1, 5, 100));
    }
}

class HspMethod {
    // 可以使用方法重载
    // 上面的三个方法名称相同，功能相同，参数个数不同 -> 使用可变参数优化
    // 1. int... 表示接受的是可变参数，类型是int，即可以接收多个int(0-多)
    // 2. 使用可变参数时，可以当作数组来使用 即nums可以当作数组
    // 3. 遍历 nums 求和即可
    public int sum(int... nums) {
//        System.out.println("接收的参数个数 = " + nums.length);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
