package PhaseOne.Intermediate.Generic_;

public class Generic03 {
    public static void main(String[] args) {
        /**
         * <p>
         *     1. 其实这样相当于就是把下面所有的E的地方，都改成了String类型
         *     2. 修改成Integer，那么就是所有的E的地方的都改成了Integer类型
         *     3. 注意: E具体的数据类型在定义Person对象的时候指定，即在编译期间，就确定E的类型
         * </p>
         * */
        Person<String> stringPerson = new Person<String>("hsp education");
        stringPerson.show();

        Person<Integer> stringPerson2 = new Person<Integer>(100);
        stringPerson2.show();
    }
}

class Person<E> {
    E s; // E表示 s的数据类型，该数据类型是在定义Person对象的时候指定的，即在编译期间，就确定E是什么类型

    // E也可以是参数类型
    public Person(E s) {
        this.s = s;
    }
    // 返回类型使用E
    public E f() {
        return s;
    }
    public void show() {
        System.out.println(s.getClass());
    }
}
