package BackUpContents._quetionMarkAndT;

import java.util.Arrays;
import java.util.List;

public class WildcardExample {

    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}


class Main01 {
    public static void main(String[] args) {
        // 使用示例
        List<String> strList = Arrays.asList("A", "B", "C");
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);

        WildcardExample.printList(strList);  // 输出: A, B, C
        System.out.println(WildcardExample.sumOfList(intList));  // 输出: 15.0
    }
}

