package ForLoop_.multiLoop;

public class multipleLoops {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.println("ok~~~");
                count = count + 1;
            }
        }
        System.out.println("count = " + count);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i = " + i + ", j = " + j);
            }
        }
    }
}
