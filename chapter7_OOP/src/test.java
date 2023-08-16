import java.util.stream.IntStream;

class test {
    public class ArrayComparison {
        public static void main(String[] args) {
            int[] array1 = { 1, 2, 3, 4, 5 };
            int[] array2 = { 1, 2, 3, 4, 5 };

            compareArrays(array1, array2);
        }

        public static boolean compareArrays(int[] arr1, int[] arr2) {
            if (arr1.length != arr2.length) {
                return false;
            }

            return IntStream.range(0, arr1.length)
                    .allMatch(i -> arr1[i] == arr2[i]);
        }
    }

}