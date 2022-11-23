package Basics.level3.Super;
/**
 *
 *
 *
 * super的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以使用super去访问爷爷类的成员；
 * 如果多个基类（上级类）中都有同名的成员，使用super访问遵循就近原则。A->B->C
 * */
public class Super01 {
    public static void main(String[] args) {
        B b = new B(); // 子类对象
//        b.sum();
        b.test();
    }
}
