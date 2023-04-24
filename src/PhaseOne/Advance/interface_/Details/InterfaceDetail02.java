package PhaseOne.Advance.interface_.Details;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        System.out.println(IB.n1); // 6. 证明接口中的属性是static的 // 7. 接口中属性的访问形式: 接口名.属性名
        // IB.n1 = 30; // 6. 证明n1是final的，不可以再次赋值了

    }
}


interface IB {
    // 6. 接口中的属性，只能是final的，而且是public static final修饰符
    int n1 = 10; // 等价 public static final int n1 = 10;
    void hi();
}

interface IC {
    void cry();
}

// 8. 接口不能继承其它的类，但是可以继承多个别的接口
interface ID extends IB, IC {}

// 9. 接口的修饰符只能是public和默认，这点和类的修饰符是一样的
interface IE {}

// 5. 一个类可以实现多个接口
class Pig implements IB, IC {

    @Override
    public void cry() {
        
    }

    @Override
    public void hi() {
        
    }
    
}