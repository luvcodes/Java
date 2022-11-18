package Basics.level1.for_loop;

public class ForDetail {
    public static void main(String[] args) {
        // for的使用细节
        // 1. 循环条件是返回一个布尔形式的表达式
        for (int i = 1; i <= 10; i++) {
            System.out.println("Hello World!" + i);
        }
        System.out.println(" ");

        // 2. for(;循环判断条件;)中的初始化和变量迭代可以写到其他地方，
        // 但是两边的分号不能省略。
        // 这样做的话就可以做到不仅仅把i在for循环体内使用
        int i = 1;
        for (; i <= 10; ) {
            System.out.println("Hello World!" + i);
            i++;
        }
        System.out.println("i = " + i); // 因为只有在i不满足循环条件的时候才会推出循环，i>10了退出循环，那么就是11。
    }
}

class A {
    public static void main(String[] args) {
        // 无限循环
        for (;;) {
            System.out.println("ok");
        }
    }
}

class B {
    public static void main(String[] args) {
        // 循环初始值可以有多条初始化语句，但要求类型一样，并且中间有逗号分开。
        // 循环变量迭代也可以有多条变量迭代语句，中间用逗号隔开。
        int count = 3;
        for (int i = 0, j = 0; i < count; i++, j += 2) {
            System.out.println("i=" + i + " j=" + j);
        }
    }
}

