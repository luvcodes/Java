package PhaseOne.Basics.level2.array.one_dimension.array_reverse_4;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55,66};
        // 1. 把arr[0]和arr[5]进行交换 {66,22,33,44,55,11}
        // 2. 把arr[1]和arr[4]进行交换 {66,55,33,44,22,11}
        // 3. 把arr[2]和arr[3]进行交换 {66,55,44,33,22,11}
        // 4. 一共要交换3次 = arr.length / 2
        // 5. 每次交换时，对应的下标是arr[i]和arr[arr.length - 1 - i]
        for (int i = 0; i < (arr.length/2); i++) {
            int temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i];
            arr[i] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
