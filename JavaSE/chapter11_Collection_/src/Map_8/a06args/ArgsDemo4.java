package a06args;

public class ArgsDemo4 {
    public static void main(String[] args) {
        //可变参数的小细节：
        //1.在方法的形参中最多只能写一个可变参数
        //可变参数，理解为一个大胖子，有多少吃多少

        //2.在方法的形参当中，如果出了可变参数以外，还有其他的形参，那么可变参数要写在最后

        getSum(1,2,3,4,5,6,7,8,9,10);



    }


    public static int getSum( int a,int...args) {
        return 0;
    }
}
