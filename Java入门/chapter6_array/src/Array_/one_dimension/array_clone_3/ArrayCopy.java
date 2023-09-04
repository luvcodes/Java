package Array_.one_dimension.array_clone_3;

public class ArrayCopy {
    public static void main(String[] args) {
        // 将int[] arr1 = {10,20,30}拷贝到arr2数组，
        // 要求数据空间是独立的
        int[] arr1 = {10,20,30};
        // 先创建一个新数组arr2，开辟新的数据空间
        // 大小 arr1.length
        int[] arr2 = new int[arr1.length]; // new就代表了在堆内存中创建了新的内存空间

        // 遍历arr1，把每个元素拷贝到对应的元素位置
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }

        // 修改arr2，不会对arr1有影响
        arr2[0] = 100;
        //检测arr1
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        // 检测arr2
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
