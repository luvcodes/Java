package Basics.level2.array.one_dimension.array_basic_1;

public class ArrayDetail {
    public static void main(String[] args) {
        // 1. 数组是多个相同类型数据的组合，元素的数据类型必须相同
        int[] arr1 = {1,2,3,60};
        // 2. 数组中的元素可以是任何数据类型，包括基本类型和引用类型，但是不能混用
        String[] arr3 = {"北京", "shanghai", "shenzhen"};

        // 3. 数组创建后，如果没有赋值，有默认值
        // int 0, short 0, byte 0, long 0, float 0.0, double 0.0, char \u0000,
        // boolean false, String null
        short[] arr4 = new short[3];

        // 4. 使用数组的步骤：声明数组开辟空间，给数组各个元素赋值，使用数组
        // 5. 数组下标从0开始

        // 6. 数组下标必须在指定范围内使用，否则报：下标越界异常
        // 即数组的下标/索引 最小是0 最大是array.length - 1
        int[] arr = new int[5];
        System.out.println(arr[4]);

        // 7. 数组属引用类型，数组型数据是对象
    }
}
