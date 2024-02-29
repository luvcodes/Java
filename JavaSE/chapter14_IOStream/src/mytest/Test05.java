package mytest;

public class Test05 {
    public static void main(String[] args) {
        /*
         * 四种方式拷贝文件，并统计各自用时
         */

         long start = System.currentTimeMillis();


         
         long end = System.currentTimeMillis();
         System.out.println((end - start) / 1000.0 + "秒");


    }

    // 字节流的基本流: 一次读写一个字节4,588,568,576字节
    public static void method01() {
        
    }
}
