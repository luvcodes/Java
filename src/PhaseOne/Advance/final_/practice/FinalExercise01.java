package PhaseOne.Advance.final_.practice;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Area = " + circle.calArea());
    }
}


class Circle {
    private double radius;
    // 第一个位置
    private final double PI; // = 3.14;

    public Circle(double radius) {
        this.radius = radius;
        // 第二个位置
        // PI = 3.14;
    }
    {
        // 第三个位置
        PI = 3.14;
    }

    public double calArea() {
        return PI * radius * radius;
    }
}

