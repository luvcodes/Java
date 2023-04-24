package PhaseOne.Basics.level3.inheritance.secondpack;
/**
 * 子类继承了所有的属性和方法，非私有的属性和方法可以在子类直接访问，
 * 但是私有属性和方法不能在子类直接访问，要通过公共的方法去访问
 * </p>
 * 子类必须调用父类的构造器，完成父类的初始化
 * </p>
 * 当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
 * 如果父类没有提供无参构造器，则必须在子类的构造器中用super去指定使用父类的哪个构造器完成对父类
 * 的初始化工作，否则，编译不会通过
 * </p>
 * 如果希望指定去调用父类的某个构造器，则显式的调用一下
 * </p>
 * super在使用时，需要放在构造器第一行, super只能在构造器中使用
 * </p>
 * super()和this()都只能放在构造器第一行，因此这两个方法不能共存在一个构造器
 * </p>
 * java所有类都是Object类的子类，Object是所有类的基类
 * </p>
 * 父类构造器的调用不限于直接父类！将一直往上追溯知道Object类（顶级父类）
 * </p>
 * 子类最多只能纪恒一个父类（指直接继承），即java中是单继承
 * </p>
 * 不能滥用继承，子类和父类之间必须满足is-a的逻辑关系
 * */
public class ExtendsDetail {
    public static void main(String[] args) {
//        System.out.println("第一个对象======");
//        Sub sub = new Sub(); // 创建了子类Sub
//        System.out.println("第二个对象======");
//        Sub sub2 = new Sub("jack"); // 创建了子类Sub
//        sub.sayOk();
        System.out.println("第三个对象======");
        Sub sub3 = new Sub("king", 10); // 创建了子类Sub
    }
}
