package String_2.stringdemo;

/**
 * @author ryanw
 */
public class StringDemo7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        String str = arrToString(arr);
        System.out.println(str);
    }

    // 遍历数组并把数组拼接成一个字符串
    // 如果调用处需要继续使用，那么必须返回
    // 如果调用处不需要继续使用，那么可以返回也可以不返回
    public static String arrToString(int[] arr) {
        if (arr == null) {
            return "";
        }

        if (arr.length == 0) {
            return "[]";
        }

        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                // 这是拼接到了最后一个字符
                result = result + arr[i];
            } else {
                result = result + arr[i] + ", ";
            }
        }

        // 此时拼接右括号
        result = result + "]";
        return result;
    }
}
