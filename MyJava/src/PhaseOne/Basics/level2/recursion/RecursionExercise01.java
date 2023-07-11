package PhaseOne.Basics.level2.recursion;

public class RecursionExercise01 {
    public static void main(String[] args) {
        A a = new A();
//        int n = 7;
//        int res = a.fibonacci(n);
//        if (res != -1) {
//            System.out.println("When n = " + n + ", the corresponding number is " + res);
//        }

        // 桃子问题
        int day = 1;
        int peachNum = a.peach(day);
        if (peachNum != -1) {
            System.out.println("The " + day + "th day have " + peachNum + " peaches");
        }
    }
}

class A {
    /*
    * 使用递归的方式求出斐波那契数列1，1，2，3，5，8，13...给你一个整数n，求出它的值是多少
    * 1. 当n=1 斐波那契数 是1
    * 2. 当n=2 斐波那契数 是1
    * 3. 当n>=3 斐波那契数 是前两个数的和
    * */
    public int fibonacci(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibonacci(n-1) + fibonacci(n-2);
            }
        } else {
            System.out.println("要求输入的n>=1的整数");
            return -1;
        }
    }



    /*
    * 猴子吃桃子问题，有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个
    * 以后每天猴子都吃其中的一半，然后再多吃一个。当到第10天时，
    * 想再吃时
    *
    * 思路：
    * 1. day = 10, 有1个桃子
    * 2. day = 9, 有(day10+1)*2 = 4
    * 3. day = 8, (day9+1)*2 = 10
    * 4. 规律就是 前一天的桃子 = (后一天的桃子 + 1) * 2
    * */
    public int peach(int day) {
        if (day == 10) {
            return 1;
        } else if (day >= 1 && day <= 9) {
            return (peach(day + 1) + 1) * 2;
        } else {
            System.out.println("day within 1 to 10");
            return -1;
        }
    }
}