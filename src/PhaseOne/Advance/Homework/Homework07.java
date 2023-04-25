package PhaseOne.Advance.Homework;

public class Homework07 {
    public static void main(String[] args) {
        Car2 car = new Car2(60);
        car.getAir().flow();
    }
}

/**
 * 有一个Car类，有属性temperature，车内有Air类，有吹风的功能flow
 * Air会监视车内的温度，如果温度超过40度则吹冷气。如果温度低于0度则吹暖气，如果在这之间则关掉空调。
 * 实例化具有不同温度的Car对象，调用空调的flow方法。
 * 测试空调吹的风是否正确
 */

class Car2 {
    private double temperature;

    public Car2(double temperature) {
        this.temperature = temperature;
    }

    // 成员内部类
    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("Temperature higher than 40 degrees, AC produce cold air");
            }
            else if (temperature < 0) {
                System.out.println("Temperature lower than 0, AC produce warm air");
            }
            else {
                System.out.println("Temperature is normal, turn off AC");
            }
        }
    }

    // 返回Air对象
    public Air getAir() {
        return new Air();
    }
}