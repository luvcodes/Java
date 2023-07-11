package PhaseOne.Basics.level2.class_object.method;

public class Method01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.speak();
        person.cal01();
        person.cal02(50);
//        person.getSum(1, 2);
        int returnSum = person.getSum(10, 20);
        System.out.println(returnSum);
    }
}

class Person {
    String name;
    int age;
    // 成员方法
    public void speak() {
        System.out.println("我是一个好人");
    }

    public void cal01() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    /**
     * 该方法可以接收一个数n，计算1+...+n的结果
     * */
    public void cal02(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    /**
     * 可以计算两个数的和
     * */
    public int getSum(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }
}

