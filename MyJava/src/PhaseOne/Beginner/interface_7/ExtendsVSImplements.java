package PhaseOne.Beginner.interface_7;

public class ExtendsVSImplements {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("WuKong");
        littleMonkey.climbing();
        littleMonkey.swimming();
        littleMonkey.flying();
    }
}


class Monkey {
    private String name;
    public void climbing() {
        System.out.println("Monkey " + name + " can climb");
    }
    public Monkey(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

// 接口
interface Fishable {
    void swimming();
}

interface Birdable {
    void flying();
}

// 继承
// 当子类继承了父类，就自动拥有了父类的功能
// 如果子类需要扩展功能，可以通过实现接口的方式扩展
// 可以理解 实现接口，是对java单继承机制的一种补充
class LittleMonkey extends Monkey implements Fishable, Birdable {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + " by learning, the monkey can swim like a fish");
    }

    @Override
    public void flying() {
        System.out.println(getName() + " by learning, the monkey can fly like a bird");
    }
}
