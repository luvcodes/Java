package PhaseOne.Basics.level2.array.Homework;

public class Homework05 {
    /**
     * 随机生成10个整数，1-100保存到数组
     * 倒序打印，求平均值，最大值，最大值下标
     * 查找里面是否有8
     * */
    public static void main(String[] args) {

        int[] arr = new int[10];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 ) + 1;
        }

        // 正序
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        // 倒序打印
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + "\t");
        }

        // 平均值，最大值，最大值下标
        double sum = 0;
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("\nmax = " + max + ", maxIndex = " + maxIndex + ", avg = " + sum/ arr.length);
    }
}


class A {
    /**
     * 随机生成10个整数，1-100保存到数组
     * 倒序打印，求平均值，最大值，最大值下标
     * 查找里面是否有8
     * */
    public static void main(String[] args) {

        int[] arr = new int[10];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }

        // 正序
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        // 倒序打印
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + "\t");
        }

        // 平均值，最大值，最大值下标
        double sum = arr[0]; // 这样定义是为了防止在for中开始循环少了加上第一个元素，i=0的那个数
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) { // 由于第一位自己跟自己比没意义，所以从1开始
            sum += arr[i];
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("\nmax = " + max + ", maxIndex = " + maxIndex + ", avg = " + sum / arr.length);

        // 查找数组中是否有8，使用顺序查找
        int findNum = 8;
        int index = -1; // 如果找到，就把下标记录到index
        for (int i = 0; i < arr.length; i++) {
            if (findNum == arr[i]) {
                System.out.println("找到数: " + findNum + "，下标 = " + i);
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("没有找到数" + findNum);
        }

    }
}
