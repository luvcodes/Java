package List_4.test;

public class Phone {
    //Phone属性：品牌，价格。
    private String brand;
    private int price;

    public Phone() {
    }


    public Phone(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
