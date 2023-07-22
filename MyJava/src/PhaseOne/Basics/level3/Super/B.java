package PhaseOne.Basics.level3.Super;

public class B extends A{
    public int n1 = 888;

    // 访问父类的属性，但不能访问父类的private属性。super.属性名
    public void hi() {
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }
    // 访问父类的方法，不能访问父类的private方法。super.方法名
    public void ok() {
        super.test100();
        super.test200();
        super.test300();
//        super.test400(); // 不能访问父类private方法
    }
    // 访问父类的构造器：super(参数列表);只能放在构造器的第一句，只能出现一句
    public B() {
        super(); // 这样就是调用的父类的无参构造器
//        super("jack"); // 这样就是调用的父类的一个参数的构造器
        // super("jack", 10); // 这样就是调用的父类的两个参数的构造器
    }

    public void cal() {
        System.out.println("Class B's cal method...");
    }

    public void sum() {
        System.out.println("Class B's sum method...");
        // 希望调用父类A的cal方法
        // 这时，因为子类B没有cal方法，因此我可以使用下面三种方式
        // 找cal方法时，顺序是，
        // 先找本类，如果有，则调用
        // 如果没有，则找父类（如果有，并可以调用，则调用）
        // 如果父类没有，则继续找父类的父类，整个规则，就是一样的，直到Object类
        // 提示：如果查找方法的过程中，找到了，但是不能访问，则报错，cannot access
        //      如果查找方法的过程中，没有找到，则提示方法不存在

//        cal();
//        this.cal(); // 等价call
        super.cal(); // 找cal方法的顺序是直接查找父类，其他的规则一样

        // 演示访问属性的规则
        // n1和this.n1 查找的规则是
        // 先找本类，如果有，则调用
        // 如果没有，则找父类（如果用，可以调用，则调用）
        // 如果父类没有，则找父类的父类，
        System.out.println(n1);
        System.out.println("n1 = " + this.n1);
        System.out.println(super.n1);
    }

    // 编写测试方法
    public void test() {
        // super的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以使用super去访问爷爷类的成员；
        // 如果多个基类（上级类）中都有同名的成员，使用super访问遵循就近原则。A->B->C, 当然也需要遵守访问权限的相关规则
        System.out.println("super.n1 = " + super.n1);
        super.cal();
    }
}
