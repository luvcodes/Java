package CommonClasses_2.Homework;

public class Homework05 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a == b);
        /**
         * 这里是false，因为equals方法没有重写。
         * 不过equals方法确实可以比较两个String类型的object的值是否相等，不过在这里，
         * 引用类型和编译类型都是Animal，没有String类型那样子的可以直接用equals方法来比较值的条件，
         * 所以如果还想要用equals来比较，就需要在Animal类里重写equals方法。
         * */
        System.out.println(a.equals(b));
        System.out.println(a.name == b.name);

        String s4 = new String("hspedu");
        String s5 = "hspedu";

        System.out.println(s1 == s4);
        System.out.println(s4 == s5);

        String t1 = "hello" + s1;
        String t2 = "hellohspedu";
        System.out.println(t1.intern() == t2);
    }
}

class Animal {
    String name;
    public Animal(String name) {
        this.name = name;
    }
}


