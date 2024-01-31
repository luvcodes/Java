package class_object.method;

public class MethodExercise01 {
    public static void main(String[] args) {
        AA aa = new AA();
        // 因为直接返回的就是boolean，所以可以直接在if中直接判断
        if (aa.isOdd(2)) {
            System.out.println("is odd number");
        }
        else {
            System.out.println("is even number");
        }

        // 使用print方法
        aa.print(4,4,'#');
    }
}


class AA {
    // 编写类AA，判断一个数是奇数odd还是偶数，返回boolean
    // 思路：
    // 1. 方法的返回类型
    // 2. 方法的名字 isOdd
    // 3. 方法的形参 (int num)
    // 4. 方法体
    public boolean isOdd(int num) {
//        if (num % 2 != 0) {
//            return true;
//        } else {
//            return false;
//        }

//        return num % 2 != 0 ? true : false;

        return num % 2 != 0;
    }

    // 根据行、列、字符打印 对应行数和列数的字符，
    // 比如 行：4 列：4 字符：#
    /*
     * ####
     * ####
     * ####
     * ####
     * */
    // 思路
    // 1. 方法的返回类型 void
    // 2. 方法的名字 print
    // 3. 方法的形参 (int row, int col, char c)
    // 4. 方法体，循环
    public void print(int row, int col, char c) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}


