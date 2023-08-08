package PhaseOne.Basics.level3.Polymorphic.PolyMethodAndObjects;

public class PolyMethod {
    public static void main(String[] args) {
        // 我们通过不同的参数个数去调用sum方法，就会去调用不同的方法
        // 方法重载体现多态
        A a = new A();
        System.out.println(a.sum(10, 20));
        System.out.println(a.sum(10,20,30));

        B b = new B();
        /**
         * <p>
         *     方法重写体现多态
         * </p>
         * */
        a.say();
        b.say();
    }
}


class B {
    public void say(){
        System.out.println("B class say method");
    }
}

class A extends B {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
    public void say() {
        System.out.println("class A method say");
    }
}