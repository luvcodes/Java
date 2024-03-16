package InnerClass.a03innerclassdemo3;


/**
 * @author yangrunze
 */
public class Test {
    public static void main(String[] args) {
        //创建内部类的对象，并调用show方法
        Outer.Inner oi = new Outer().new Inner();
        oi.show();
    }
}
