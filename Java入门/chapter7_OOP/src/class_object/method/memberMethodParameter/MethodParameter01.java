package class_object.method.memberMethodParameter;

public class MethodParameter01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        // create new AA object
        AA aa = new AA();
        aa.swap(a, b);

        // 10 and 20
        System.out.println("a=" +  a + " b= " + b);
    }
}

class AA {
    public void swap(int a, int b) {
        System.out.println("\na和b交换的值\na=" + a + "\tb=" + b);
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a=" + a + "\tb=" + b);
    }
}
