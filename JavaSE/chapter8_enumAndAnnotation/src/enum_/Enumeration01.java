package enum_;

public class Enumeration01 {
    public static void main(String[] args) {
        // 对于季节而言，它的对象(具体值), 是固定的四个，不会有更多
        // 这样不能提现季节是固定的四个对象
        // 因此，这样的设计不好
        Season3 spring = new Season3("Spring", "Warm");
        Season3 summer = new Season3("Summer", "Hot");
        Season3 autumn = new Season3("Autumn", "Cool");
        Season3 winter = new Season3("Winter", "Cold");
    }
}

class Season3 {
    private String name;
    private String description;

    public Season3(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
