package StaticClassVar;

public class ChildGame {
    public static void main(String[] args) {
        // 定义一个变量count, 统计有多少小孩加入了游戏
        Child child1 = new Child("Ryan");
        child1.join();
        child1.count++;

        Child child2 = new Child("Jack");
        child2.join();
        child2.count++;

        Child child3 = new Child("Ted");
        child3.join();
        child3.count++;

        System.out.println("In total: " + Child.count + " children joined the game.");
        System.out.println("Child1.count = " + child1.count);
        System.out.println("Child2.count = " + child2.count);
        System.out.println("Child3.count = " + child3.count);

    }
}

class Child {
    private String name;
    // 定义一个变量count, 是一个类变量(静态变量) static
    // 该变量最大的特点就是会被Child类的所有的对象实例共享
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + " joined the game.");
    }
}
