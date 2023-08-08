package PhaseOne.Basics.level3.Polymorphic.PolyMethodAndObjects.objpoly;

public class PolyObject {
    public static void main(String[] args) {
        // 体验对象多态特点
        // animal 编译类型就是 Animal, 运行类型 Dog
        Animal animal = new Dog();
        // 因为运行时，这时就执行到该行时，animal运行类型是Dog，所以cry就是Dog的cry
        animal.cry();

        // animal 编译类型就是 Animal, 运行类型 Cat
        animal = new Cat();
        animal.cry();
    }
}
