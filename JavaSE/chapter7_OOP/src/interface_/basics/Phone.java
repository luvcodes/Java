package interface_.basics;

/**
 * @author ryanw
 */
public class Phone implements UsbInterface {
    @Override
    public void start() {
        System.out.println("Phone start working");
    }

    @Override
    public void stop() {
        System.out.println("Phone stop working");
    }
}
