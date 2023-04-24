package PhaseOne.Advance.interface_.Details;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        // new IA();
    }
}

// 1. 接口不能被实例化
// 2. 接口中所有的方法是public方法，接口中抽象方法，可以不用abstract修饰
// 3. 一个普通类实现接口，就必须将该接口的所有方法都实现
interface IA {
    void say();
    void hi();
}

class Cat implements IA {
    @Override
    public void say() { /* TODO document why this method is empty */ }

    @Override
    public void hi() { /* TODO document why this method is empty */ }
}

// 4. 抽象类实现接口时，可以不实现接口的抽象方法
abstract class Tiger implements IA {

}