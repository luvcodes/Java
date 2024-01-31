package inheritance._exercise;

public class PC extends Computer{
    private String brand;

    // 这里也体现：继承设计的基本思想，父类的构造器完成父类属性初始化
    // 子类的构造器完成子类属性初始化
    public PC(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void printInfo() {
        System.out.println("PC info as follows: ");
        // 直接调用父类的getDetails()
        System.out.println(getDetails() + " brand = " + this.brand);
    }
}
