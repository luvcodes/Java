package PhaseOne.Intermediate.Generic_;

import java.util.ArrayList;
import java.util.List;

public class GenericDetail {
    public static void main(String[] args) {
        /**
         * <p>
         *     1. 给泛型指向数据类型是，要求是引用数据类型，不能是基本数据类型
         * </p>
         * */
        List<Integer> list = new ArrayList<Integer>(); // OK
//        ArrayList<int> list2 = new ArrayList<int>(); // Error

        /**
         * <p>
         *     2. 因为E指定了A类型，构造器传入了 new A()
         *        在给泛型执行具体类型后，可以传入该类型或者起子类类型
         * </p>
         *
         * */
        Pig<A> aPig = new Pig<A>(new A());
        aPig.f();
        Pig<A> aPig2 = new Pig<A>(new B());
        aPig2.f();

        /**
         * <p>
         *     3. 泛型的使用形式
         * </p>
         * */
        List<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        // 在实际开发中，我们往往简写
        // 编译器会进行类型推断
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        ArrayList<Pig> pigs = new ArrayList<>();
    }
}


class A {}
class B extends A {}

class Pig<E> {
    E e;

    public Pig(E e) {
        this.e = e;
    }
    public void f() {
        System.out.println(e.getClass());
    }
}