package enum_;
import java.util.*;

public class EnumTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = scanner.next().toUpperCase();
        /**
         * valueOf 方法用于获取枚举类中特定名称的枚举实例。这是一个静态方法，通常用在Java的枚举类型上。
         *
         * 参数
         * Class<T> enumType: 第一个参数是枚举类的Class对象。这告诉valueOf方法要查找哪个枚举类型。
         * 例如，在你的代码中，这是Size.class。
         * String name: 第二个参数是一个字符串，表示要查找的枚举实例的名称。这个名称是区分大小写的。
         * 在你的代码中，这是"SMALL"。
         *
         * 这里，Enum.valueOf(Size.class, "SMALL") 将查找名为 SMALL 的 Size 枚举实例，并将其返回。
         * */
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the _.");
        }
    }
}

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private String abbreviation;
    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation() {
        return abbreviation;
    }
}
