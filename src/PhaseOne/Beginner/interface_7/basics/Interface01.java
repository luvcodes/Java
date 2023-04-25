package PhaseOne.Beginner.interface_7.basics;

public class Interface01 {
    public static void main(String[] args) {
        // Create phone, camera
        Camera camera = new Camera();
        Phone phone = new Phone();
        Computer computer = new Computer();
        computer.work(phone); // Plugin phone to computer
        System.out.println("========================");
        computer.work(camera); // Plugin camera to computer
    }
}
