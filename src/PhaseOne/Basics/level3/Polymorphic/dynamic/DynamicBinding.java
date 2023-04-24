package PhaseOne.Basics.level3.Polymorphic.dynamic;

/**
 * Java的动态类型绑定：
 * 1. 当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
 * 2. 当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用
 * */
public class DynamicBinding {

    /**
     * 几种情况的测试：
     * 原始状态，只需要先找运行类型，也就是B类，在B类里就可以执行完所有需要的方法
     * </p>
     * 注释掉B类里的sum方法，那么就会出现B类里没有sum方法，就会去A类里找sum方法，在A类里的sum方法需要getI方法，这个getI方法会去B类里找，那么i的值
     * 也就是B类里的i的值。找到i的值以后再回到A类里执行完sum方法
     * </p>
     * 注释掉B类里的sum和sum1两个方法，sum方法跟上面的执行方法一样，sum1由于不需要getI方法，直接使用A类里面的i的值即可
     * */
    public static void main(String[] args) {
        // a 编译类型 A，运行类型 B
        // 会先去子类找，子类如果sum()注释掉，就回去父类找sum()
        A a = new B(); // 向上转型
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}
class A {
    public int i = 10;
    public int sum() {
        return getI() + 10;
    }
    public int sum1() {
        return i + 10;
    }
    public int getI() {
        return i;
    }
}

class B extends A {
    public int i = 20;
    public int sum() {
        return i + 20;
    }
    public int getI() {
        return i;
    }
    public int sum1() {
        return i + 10;
    }
}