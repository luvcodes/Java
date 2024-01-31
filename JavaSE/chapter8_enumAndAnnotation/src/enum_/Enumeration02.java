package enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}


class Season {
    private String name;
    private String description;

    // 定义了四个对象
    public final static Season SPRING = new Season("Spring", "Warm");
    public final static Season SUMMER = new Season("Summer", "Hot");
    public final static Season AUTUMN = new Season("Autumn", "Cool");
    public final static Season WINTER = new Season("Winter", "Cold");

    // 1. 将构造器私有化，目的防止 直接 new
    // 2. 去掉setXxx方法，防止属性被修改
    // 3. 在Season内部，直接创建固定的对象
    // 4. 优化，可以加入 final 修饰符
    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
