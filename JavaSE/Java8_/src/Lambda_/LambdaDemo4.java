package Lambda_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ryanw
 */
public class LambdaDemo4 {
    public static void main(String[] args) {
        String[] arr = {"a", "aaaa", "aaa", "aa"};

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 按照字符串长度排序
                return o1.length() - o2.length();
            }
        });

        Arrays.sort(arr, (String o1, String o2) -> {
            return o1.length() - o2.length();
        });

        // lambda简化写法
        // 小括号: 数据类型可以省略，如果参数只有一个，小括号还可以省略
        // 大括号: 如果方法体只有一行，return，分号，大括号都可以省略
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());

        System.out.println(Arrays.toString(arr));
    }
}
