package InnerClass.a02innerclassdemo2;

/**
 * @author ryanw
 */
public class Outer {
    String name;

    private static class Inner{
        static int a = 10;
    }


    public Inner getInstance(){
        return new Inner();
    }


}
