package _quetionMarkAndT;

// 使用T定义一个泛型类
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

// 使用T定义一个泛型方法
class Utility {
    public static <T> void print(T item) {
        System.out.println(item);
    }
}

class Main {
    public static void main(String[] args) {
        // 使用示例
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(123);
        Utility.print(stringBox.getValue());  // 输出: Hello
        Utility.print(intBox.getValue());     // 输出: 123

    }
}
