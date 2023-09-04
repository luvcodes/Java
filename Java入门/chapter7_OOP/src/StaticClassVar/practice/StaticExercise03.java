package StaticClassVar.practice;

/**
 * 静态方法 只能访问静态成员
 * 非静态方法 可以访问所有的成员
 * 编写代码时 仍然要遵守访问权限的规则
 * */

public class StaticExercise03 {
    private int id;
    public static int total = 0;
    public static void setTotalPerson(int total) {
    //   this.total = total; // 错误 因为在static方法中不能使用this
        StaticExercise03.total = total; // 这样写就可以了
    }
    public StaticExercise03() {
        total++;
        id = total;
    }

    // 编写一个方法 输出total的值
    public static void m() {
        System.out.println("Total = " + total);
    }
}

class TestStaticExercise03 {
    public static void main(String[] args) {
        StaticExercise03.setTotalPerson(3);
        StaticExercise03 staticExercise03 = new StaticExercise03();
        StaticExercise03.m();
    }
}
