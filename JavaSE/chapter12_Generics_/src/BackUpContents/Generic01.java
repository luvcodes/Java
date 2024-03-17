package BackUpContents;

import java.util.ArrayList;

/**
 * @author ryanw
 */
public class Generic01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog01("teddy", 3));
        arrayList.add(new Dog01("beta", 4));
        arrayList.add(new Dog01("mark", 3));

        arrayList.add(new Cat01("zhaocaimao", 5));

        for (Object o : arrayList) {
            // 向下转型
            // 为了获取到dog.getName和getAge方法，所以必须要进行向下转型
            // 不支持直接把arrayList直接给Dog o，所以必须得给Object o，然后在进行向下转型
            Dog01 dog = (Dog01) o;
            System.out.println(dog.getName() + " " + dog.getAge());
        }
    }
}


class Dog01 {
    private String name;
    private int age;

    public Dog01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BackUpContents.Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Cat01 {
    private String name;
    private int age;

    public Cat01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BackUpContents.Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
