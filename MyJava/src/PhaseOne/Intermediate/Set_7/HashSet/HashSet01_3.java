package PhaseOne.Intermediate.Set_7.HashSet;

import java.util.HashSet;

public class HashSet01_3 {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        //说明
        //1. 在执行add方法后，会返回一个boolean值
        //2. 如果添加成功，返回 true, 否则返回false
        //3. 可以通过 remove 指定删除哪个对象
        System.out.println(set.add("john"));//T
        System.out.println(set.add("lucy"));//T
        System.out.println(set.add("john"));//F
        System.out.println(set.add("jack"));//T
        System.out.println(set.add("Rose"));//T
        set.remove("john");
        System.out.println("set=" + set);//3个

        set = new HashSet<>();
        System.out.println("set=" + set);//0
        //4. Hashset 不能添加相同的元素/数据?
        /**
         * 这两个lucy都指向字符串常量池
         * */
        set.add("lucy");//添加成功
        set.add("lucy");//加入不了

        /**
         * 这是两个不同的Dog对象，只是都叫做tom而已
         * */
        set.add(new Dog("tom"));//OK
        set.add(new Dog("tom"));//Ok
        System.out.println("set=" + set);

        /**
         *
         * */
        set.add(new String("hsp"));//ok
        set.add(new String("hsp"));//加入不了.
        System.out.println("set=" + set);
    }
}


class Dog { //定义了Dog类
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}