package PhaseOne.enum_;

public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.WINTER);
    }
}

enum Season2 {
    // 如果使用enum 来实现枚举类
    // 1. 使用关键字enum替代class
    // 2. public final static Season SPRING = new Season2("Spring", "Warm");
    // SPRING("Spring", "Warm"); 常量名(实参列表)
    // 3. 如果有多个常量(对象), 使用逗号间隔
    // 4. 如果使用enum来实现枚举，要求将定义敞亮对象，写在最前面
    SPRING("Spring", "Warm"), SUMMER("Summer", "Hot"), AUTUMN("Autumn", "Cool"), WINTER("Winter", "Cold");
    private String name;
    private String description;

    private Season2(String name, String description) {
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
