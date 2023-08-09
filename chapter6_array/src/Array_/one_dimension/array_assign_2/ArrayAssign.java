package Array_.one_dimension.array_assign_2;

public class ArrayAssign {
    public static void main(String[] args) {
        // 基本数据类型赋值，赋值方式为值拷贝
        int n1 = 2;
        int n2 = n1;
        n2 = 8;
        System.out.println(n1);
        System.out.println(n2);

        // 数组在默认情况下是引用传递，赋的值是地址，赋值方式为引用传递/地址拷贝
        // 是一个地址，arr2的变化会影响到arr1的值
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr2[0] = 10;
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
