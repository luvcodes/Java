package PhaseOne.Advance.InnerClass.LocalInnerClass;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        // 匿名内部类可以当作实参直接传递
        // 这样写就不用像传统方法那样 一旦修改类 就得修改所有的输出了
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("This is a famous painting");
            }
        });
        // 传统方法
        f1(new Picture());
    }

    // 静态方法，形参是接口类型
    public static void f1(IL il) {
        il.show();
    }
}

interface IL {
    void show();
}

// 类 -> 实现IL -> 编程领域(硬编码)
class Picture implements IL {
    @Override
    public void show() {
        System.out.println("This is a famous painting");
    }
}