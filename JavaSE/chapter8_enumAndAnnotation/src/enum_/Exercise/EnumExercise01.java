package enum_.Exercise;

public class EnumExercise01 {
    public static void main(String[] args) {
        Gender2 boy = Gender2.BOY;
        Gender2 boy2 = Gender2.BOY;
        System.out.println(boy);

        /**
         * 在Java中，枚举 (enum) 是一种特殊的数据类型，允许一个变量拥有预定义的常量集合。
         * 每一个枚举常量都是枚举类型的实例。而这些实例在JVM加载枚举类时被实例化，这也意味着枚举实例是在JVM中单例的。
         * </p>
         * boy 和 boy2 都引用同一个 Gender2.BOY 实例。因此，boy == boy2 返回 true，这是因为它们引用的是内存中的同一个对象。
         * 这是枚举在Java中的一个特性，它确保了对于给定的枚举类型，每一个枚举常量只有一个实例，因此 == 可以安全地用于比较两个枚举常量是否相等。
         * */
        System.out.println(boy == boy2);
    }
}

enum Gender2 {
    BOY, GIRL;
}