package PhaseOne.Beginner.Homework;

public class Homework06 {
    public static void main(String[] args) {
        Person person = new Person("Mark", new Horse());
        person.common();
        person.passRiver();
        person.passFireHill();
    }
}

/**
 * 1. 交通工具接口类Vehicles，有work接口
 * 2. 有Horse类和Boat类分别实现Vehicles
 * 3. 创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
 * 4. 有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
 * 5. 实例化Person对象，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
 * 6. 增加一个情况，如果要过火焰山，使用飞机 => 程序扩展器
 * 
 */

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("Usually use horse as transportation");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("Use boat to cross river");
    }
}

class Plane implements Vehicles {
    @Override
    public void work() {
        System.out.println("Use plane to pass fire hill");
    }
}

class VehiclesFactory {
    // 马儿始终是同一匹
    private static Horse horse = new Horse(); // 饿汉式
    private VehiclesFactory() {}

    // 这里将方法做成static比较方便，类名.方法名 就可以直接访问
    public static Horse getHorse() {
        // return new Horse();
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
    public static Plane getPlane() {
        return new Plane();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    // 编程思路，可以把具体的要求，封装成方法
    // 如何不浪费，在构建对象时传入的交通工具对象
    public void passRiver() {
        // 判断当前vehicles属性是null，就获取一艘船
        // Boat boat = new Boat();
        // boat.work();
        // 如何防止始终使用的是传入的马 instanceof
        // if (vehicles == null) {
        // vehicles instanceof Boat 是判断当前的vehicles是不是Boat
        // (1) vehicles = null : vehicles instanceof Boat => false
        // (2) vehicles = horse object : vehicles instanceof Boat => false
        // (3) vehicles = boat object : vehicles instanceof Boat => true
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void common() {
        // 判断一下，当前的vehicles属性是null, 就获取一匹马
        // if (vehicles != null) {
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        // 这里体现使用接口调用
        vehicles.work();
    }

    public void passFireHill() {
        if (!(vehicles instanceof Plane)) {
            vehicles = VehiclesFactory.getPlane();
        }
        vehicles.work();
    }
}
