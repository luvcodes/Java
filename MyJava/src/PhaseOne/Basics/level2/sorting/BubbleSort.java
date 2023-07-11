package PhaseOne.Basics.level2.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        /*
        目标是把最大数放在最后

        总结冒泡排序特点
        1. 一共有5个元素
        2. 一共进行了四轮排序，可以看成是外层循环
        3. 每一轮排序可以确定一个数的位置，比如第一轮排序确定最大数，第二轮排序，确定第二大数的位置，以此类推。
        4. 当进行比较时，如果前面的数大于后面的数，就交换
        5. 每轮比较在减少 4->3->2->1
        6. 最后将多层排序使用外层循环包起来即可

        24, 69, 80, 57, 13冒泡排序法排成从小到大的有序数列
        轮数：length - 1
         */

        int[] arr = {24, 69, 80, 57, 13};
        // 交换用于辅助交换的变量
        int temp = 0;

        // 第一轮四次比较
        for (int j = 0; j < 4; j++) {
            // 如果前面的数大于后面的数，就交换
            // 把前一位的数赋给temp，后面的一位就是arr[j+1]
            if (arr[j] > arr[j+1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }

        System.out.println("第一轮排序");
        // 遍历数组，检测80是不是到最后一位了
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
    }
}

class A {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
        int temp = 0;
        // 4轮，外层循环4次
        for (int i = 0; i < 4; i++) {
            // j < 4 - i, 4次比较 -3 -2 -1次
            for (int j = 0; j < 4-i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("\nThis is " + (i+1) + "th round.");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "\t");
            }
        }
    }
}

class B {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            // 4就是arr.length - 1
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            System.out.println("\nThis is " + (i+1) + "th round.");
            for (int k : arr) {
                System.out.print(k + "\t");
            }
        }
    }
}
