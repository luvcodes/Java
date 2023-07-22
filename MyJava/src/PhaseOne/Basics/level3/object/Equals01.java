//package PhaseOne.Basics.level3.object;
//
//public class Equals01 {
//    public static void main(String[] args) {
//        A a = new A();
//        A b = a;
//        A c = b;
//        System.out.println(a == c);
//        System.out.println(b == c);
//
//        B bObj = a; // 这其实就是向上转型，子类的对象赋给B类的引用
//        System.out.println(bObj == c);
//
//        int num1 = 10;
//        double num2 = 10.0;
//        System.out.println(num1 == num2);
//
//        // String类的equals 方法，源码查看
//        // 把Object的equals方法重写了，变成了比较两个字符串的值是否相等
//        "hello".equals("1");
//
//        // Object类的equals是
//        // 即Object的equals方法默认就是比较对象的地址是否相等
//        // 也就是判断两个对象是不是同一个对象
//
//        // Integer也重写了Object的equals方法，变成了判断两个值是否相等
//        Integer integer = new Integer(5);
//
//
//        // 练习
//        Integer integer1 = new Integer(1000);
//        Integer integer2 = new Integer(1000);
//        System.out.println(integer1 == integer2); // ? false
//        System.out.println(integer1.equals(integer2));// ? true
//
//        String hspedu = new String("hspedu");
//        String hspedu1 = new String("hspedu");
//        System.out.println(hspedu == hspedu1); // false，判断 不是同一个对象
//        System.out.println(hspedu.equals(hspedu1)); // true，判断 是同一个值
//    }
//}
//class B{}
//class A extends B{}
