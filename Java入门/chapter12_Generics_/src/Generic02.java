import java.util.ArrayList;

public class Generic02 {
    public static void main(String[] args) {
        /**
         * <p>
         *     1. 当我们ArrayList<Dog>表示存放到ArrayList集合中
         *     2. 如果编译器发现添加的类型，不满足要求，就会报错
         *     3. 在遍历的时候，可以直接取出Dog类型，而不是Object
         * </p>
         * */
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("teddy", 3));
        arrayList.add(new Dog("beta", 4));
        arrayList.add(new Dog("mark", 3));

        // accidentally added a cat
//        arrayList.add(new Cat("zhaocaimao", 5));

        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + " " + dog.getAge());
        }
    }
}



class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
