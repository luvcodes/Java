package PhaseOne.Intermediate.Collection_3;

import java.util.Vector;

public class Vector_1 {
    public static void main(String[] args) {
        // 无参构造器
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        // 有参数的构造
        Vector vector = new Vector(8);
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        System.out.println("vector = " + vector);
    }
}
