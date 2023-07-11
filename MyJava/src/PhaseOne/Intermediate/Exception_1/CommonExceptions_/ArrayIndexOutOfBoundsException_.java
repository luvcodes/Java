package Exception_1.CommonExceptions_;

public class ArrayIndexOutOfBoundsException_ {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        // <= 的时候，也就是index = 3，会抛出数组下标越界
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
