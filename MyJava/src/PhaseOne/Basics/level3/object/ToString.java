package PhaseOne.Basics.level3.object;

public class ToString {
    /**
     * Object的toString() 源码
     * getClass().getName()类的全类名（包名+类名)
     * Integer.toHexString(hashCode)) 将对象的hashCode值转成16进制的字符串
     * @return
     public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    Object
    */
    public static void main(String[] args) {
        Monster monster = new Monster("a", "guardian", 1000);
        System.out.println(monster.toString() + " hascode = " + monster.hashCode());

        System.out.println("当直接输出一个对象时，toString方法会被默认的调用");
        System.out.println(monster); // 等价于 monster.toString
    }


}

class Monster {
    private String name;
    private String job;
    private double sal;

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    // 重写toString方法，输出对象的属性
    // 使用快捷键即可 alt+insert -> toString
    @Override
    public String toString() { // 重写后，一般是把对象的属性值输出，当然程序员也可以自己定制
        return "Monster{" +
                "name'" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal-" + sal +
                '}';
    }


}
