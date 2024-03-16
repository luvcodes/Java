package InnerClass.a01innerclassdemo1;

/**
 * @author yangrunze
 */
public class Car {
    String carName;
    int carAge;
    String carColor;

    // 这里要注意，可能Car this这样传参数的方法是不正确的
    public void show(Car this){
        //是打印调用者车的名字：宾利
        System.out.println(this.carName);
        Engine e = new Engine();
        System.out.println(e.engineName);
    }

    class Engine{
        String engineName;
        int engineAge;

        public void show(){
            System.out.println(engineName);
            System.out.println(carName);
        }
    }
}
