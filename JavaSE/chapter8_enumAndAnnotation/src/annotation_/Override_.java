package annotation_;

public class Override_ {
    public static void main(String[] args) {

    }
}

class Father {
    public void fly() {
        System.out.println("Father fly...");
    }
}

class Son extends Father {
    // 1. @Override 注解在fly方法上，表示子类的fly方法是重写了父类的fly方法
    // 2. 如果这里没有写@Override还是重写了父类的fly
    // 3. 如果写了@Override注解，编译器就会去检查该方法是否真的重写了父类的方法，如果的确重写了，则编译通过，如果没有构成重写，则编译错误
    @Override
    public void fly() {
        System.out.println("Son fly...");
    }
}
