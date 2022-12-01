package Basics.level3.Polymorphic.Intro;

public class Master {
    private String name;
    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 主人给小狗 喂食 骨头
    public void feed(Dog dog, Bone bone) {
        System.out.println("Master " + name + " gives " + dog.getName() + " feed " + bone.getName());
    }
    // 主人给 小猫喂 黄花鱼
    public void feed(Cat cat, Fish fish) {
        System.out.println("Master " + name + " gives " + cat.getName() + " feed " + fish.getName());
    }

    // 如果动物很多，食物很多
    // feed方法很多，不利于管理和维护
}
