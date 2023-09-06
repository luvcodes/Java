import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class GenericDetail {
    public static void main(String[] args) {
        // 1. 给泛型指向数据类型是，要求是引用数据类型，不能是基本数据类型
        List<Integer> list = new ArrayList<Integer>(); // OK
//        ArrayList<int> list2 = new ArrayList<int>(); // Error

        /**
         * 2. 因为E指定了A类型，构造器传入了 new A()
         *    在给泛型执行具体类型后，可以传入该类型或者起子类类型
         * */
        Pig<A> aPig = new Pig<A>(new A());
        aPig.f();
        Pig<A> aPig2 = new Pig<A>(new B());
        aPig2.f();
        System.out.println();

        /**
         * 3. 泛型的使用形式
         * */
        List<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        // 在实际开发中，我们往往简写
        // 编译器会进行类型推断
//        ArrayList<Integer> list3 = new ArrayList<>();
//        List<Integer> list4 = new ArrayList<>();

        ArrayList<Pig> pigs = new ArrayList<>();
        pigs.add(aPig);
        pigs.add(aPig2);
        for (Pig pig : pigs) {
            System.out.println(pig);
            pig.f();
        }

        /**
         * 4. 如果是这样写 泛型默认是Object
         *    等价于 ArrayList<Object> arrayList = new ArrayList<Object>()
         * */
        ArrayList arrayList = new ArrayList();
    }
}

class Tiger<E> {
    E e;

    public Tiger() {}
    public Tiger(E e) {
        this.e = e;
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