package PracticeQuestions;

import PracticeQuestions.*;

import java.util.ArrayList;

/**
 * @author ryanw
 */
public class Test01 {
    public static void main(String[] args) {
                /*
            需求：
                定义一个继承结构：
                                    动物
                         |                           |
                         猫                          狗
                      |      |                    |      |
                   波斯猫   狸花猫                泰迪   哈士奇


                 属性：名字，年龄
                 行为：吃东西
                       波斯猫方法体打印：一只叫做XXX的，X岁的波斯猫，正在吃小饼干
                       狸花猫方法体打印：一只叫做XXX的，X岁的狸花猫，正在吃鱼
                       泰迪方法体打印：一只叫做XXX的，X岁的泰迪，正在吃骨头，边吃边蹭
                       哈士奇方法体打印：一只叫做XXX的，X岁的哈士奇，正在吃骨头，边吃边拆家

            测试类中定义一个方法用于饲养动物
                public static void keepPet(ArrayList<???> list){
                    //遍历集合，调用动物的eat方法
                }
            要求1：该方法能养所有品种的猫，但是不能养狗
            要求2：该方法能养所有品种的狗，但是不能养猫
            要求3：该方法能养所有的动物，但是不能传递其他类型
         */


        // 创建各种动物的实例
        PersianCat persianCat = new PersianCat("Persian", 2);
        LihuaCat lihuaCat = new LihuaCat("Lihua", 1);
        TeddyDog teddyDog = new TeddyDog("Teddy", 3);
        HuskyDog huskyDog = new HuskyDog("Husky", 4);

        // 分别创建各种动物的列表
        ArrayList<PersianCat> list1 = new ArrayList<>();
        list1.add(persianCat);

        ArrayList<LihuaCat> list2 = new ArrayList<>();
        list2.add(lihuaCat);

        ArrayList<TeddyDog> list3 = new ArrayList<>();
        list3.add(teddyDog);

        ArrayList<HuskyDog> list4 = new ArrayList<>();
        list4.add(huskyDog);

        // 调用keepPet方法
        // 这会打印出波斯猫正在吃小饼干的信息
        keepPet(list1);
        // 这会打印出狸花猫正在吃鱼的信息
        keepPet(list2);
        // 这会打印出泰迪正在吃骨头，边吃边蹭的信息
        keepPet(list3);
        // 这会打印出哈士奇正在吃骨头，边吃边拆家的信息
        keepPet(list4);
    }

    // 要求1：该方法能养所有品种的猫，但是不能养狗
    /*public static void keepPet(ArrayList<? extends Dog> list) {
        for (Dog dog : list) {
            dog.eat();
        }
    }*/

    // 要求2：该方法能养所有品种的狗，但是不能养猫
    /*public static void keepPet(ArrayList<? extends Cat> list) {
        for (Cat cat : list) {
            cat.eat();
        }
    }*/

    // 要求3: 该方法能养所有的动物，但是不能传递其他类型
    public static void keepPet(ArrayList<? extends Animal> list) {
        for (Animal animal : list) {
            animal.eat();
        }
    }
}
