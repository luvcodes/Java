package PhaseOne.enum_;

import PhaseOne.enum_.Season2;

public class EnumMethod {
    public static void main(String[] args) {
        // 使用Season2枚举类，来演示各种方法
        Season2 autumn = Season2.AUTUMN;
        // 输出枚举对象的名字
        System.out.println(autumn.name());
        // ordinal() 输出的是该枚举对象的次序/编号，从0开始编号
        // AUTUMN枚举对象是第三个，所以输出2
        System.out.println(autumn.ordinal());
        // 从反编译可以看出 values方法，返回Season2[]
        // 含有定义的所有枚举对象
        Season2[] values = Season2.values();
        System.out.println("===Extract the tuple objects===");
        for (Season2 season: values) {
            System.out.println(season);
        }

        // int[] nums = {1,2,9};
        // // 普通的for循环
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.println(nums[i]);
        // }
        // // 执行流程是 依次从nums数组中取出数据，赋给i，如果取出完毕，则退出for
        // System.out.println();
        // for (int i : nums) {
        //     System.out.println("i = " + i);
        // }
    }
}
