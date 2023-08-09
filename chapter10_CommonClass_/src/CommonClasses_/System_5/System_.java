package CommonClasses_.System_5;

import java.util.Arrays;

public class System_ {
    public static void main(String[] args) {
        System.out.println("ok1");
        // 表示程序退出，0表示一个状态，正常状态
//        System.exit(0);
//        System.out.println("ok2");

        /**
         * arraycopy: 复制元素数组
         * 5个参数的含义: 看源码
         * */
        int[] src = {1,2,3};
        int[] dest = new int[3];
        System.arraycopy(src, 0, dest, 1, 2); // 最后一个参数可以改成src.length
        System.out.println(Arrays.toString(dest));

        // currentTimeMillens: 返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());
    }
}
