package PhaseOne.Basics.level3.Polymorphic.exercise_;

public class PolyExercise01 {
    public static void main(String[] args) {
        double d = 13.4;
        long l = (long) d;
        System.out.println(l);

        int in = 5;
//        boolean b = (boolean) in; // 不对，boolean -> int是不可以的

        Object obj = "Hello"; // 可以，向上转型
        String objStr = (String) obj; // object转成字符串，向下转型
        System.out.println(objStr);

//        Object objPri = new Integer(5); // 可以，向上转型
        // String str = (String) objPri; // 错误，指向Integer的父类引用，转成String
        // Integer str1 = (Integer) objPri; // 可以，向下转型
    }
}
