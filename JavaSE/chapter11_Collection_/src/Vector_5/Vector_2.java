package Vector_5;

import java.util.Vector;

/**
 * @author ryanw
 */
public class Vector_2 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Python");
        vector.add("C++");
        vector.add("JavaScript");

        System.out.println("Vector size: " + vector.size());
        System.out.println("Vector contains java? " + vector.contains("Java"));
        System.out.println("Vector contains Ruby? " + vector.contains("Ruby"));
        System.out.println("Vector first element: " + vector.firstElement());
        System.out.println("Vector last element: " + vector.lastElement());
        System.out.println("Vector element at index 2: " + vector.get(2));
        vector.remove(2);
        System.out.println("Vector after remove element at index 2: " + vector);
        System.out.println("Vector size after remove: " + vector.size());
        vector.clear();
        System.out.println("Vector after clear: " + vector);
    }
}
