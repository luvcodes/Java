package PhaseOne.Advance.DesignPattern.single_;

public class SingleTon01 {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);
    }
}

// 有一个类, GirlFriend
class GirlFriend {
    private String name;
    // public static int n1 = 100;
    // 为了能够在静态方法中使用，返回gf对象，需要将其修饰为static
    // 对象，通常是重量级的对象，饿汉式可能造成创建了对象，但是没有使用
    private static GirlFriend gf = new GirlFriend("Emma");

    // 如何保障我们只能创建一个GirlFriend对象
    // 步骤:
    // 1. 将构造器私有化，因为私有的方法只能在本类调用
    // 2. 在类的内部直接创建
    // 3. 提供一个公共的static方法，返回gf对象
    private GirlFriend(String name) {
        this.name = name;
    }

    // 如果这里不用static，就代表还是得去main方法里new对象，也就不是单例模式了。
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" + "name='" + name + '\'' + '}';
    }
}