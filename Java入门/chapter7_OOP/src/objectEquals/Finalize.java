package objectEquals;

public class Finalize {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        // 这时car对象就是一个垃圾对象，垃圾回收器就会回(销毁)对象，在销毁对象前，会调用该对象的finalize()方法
        // 程序员就可以在finalize中，写自己的业务逻辑代码(比如释放资源，数据库的连接，或者打开文件...)
        // 如果程序员不重写 finalize方法，那么就会调用Object类的finalize，即默认处理
        // 如果程序员重写了 finalize，就可以实现自己的逻辑
        bmw = null;
        System.gc(); // 主动调用垃圾回收器
        System.out.println("程序退出了...");
    }
}

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    // 重写finalize
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我们销毁 汽车" + name);
        System.out.println("释放了某些资源...");
    }
}