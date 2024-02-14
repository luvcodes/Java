package interface_.basics;

/**
 * @author ryanw
 */
public class Interface01 {
    public static void main(String[] args) {
        Camera camera = new Camera();
        Phone phone = new Phone();
        Computer computer = new Computer();
        // Plugin phone to computer
        computer.work(phone);
        System.out.println("========================");
        // Plugin camera to computer
        computer.work(camera);
    }
}
