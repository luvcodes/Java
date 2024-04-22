package BackUp.Reflection;


public class Car {
    public String brand = "宝马";//品牌
    public int price = 500000;
    public String color = "白色";

    public void printMethod() {
        System.out.println("This is a car class");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
