public class Test {
    public static void main(String[] args) {
         int[] nums = {1,3,5,7,9,10,11,20,11};
         binarySearch(nums, 4, 7);
    }

    public static int binarySearch(int[] nums, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > value) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
