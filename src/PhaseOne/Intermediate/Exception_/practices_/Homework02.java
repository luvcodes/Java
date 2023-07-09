package PhaseOne.Intermediate.Exception_.practices_;

public class Homework02 {
    public static void main(String[] args) {
        // args.length = 0;
        // 直接运行的话，这里发生的是 ArrayIndexOutOfBoundsException
        if (args[4].equals("john")) { // 可能发生NullPointerException
            System.out.println("AA");
        } else {
            System.out.println("BB");
        }
        Object o = args[2]; // String -> Object，向上转型
        Integer i = (Integer) o; // 错误，这里一定会发生 ClassCastException
    }
}
