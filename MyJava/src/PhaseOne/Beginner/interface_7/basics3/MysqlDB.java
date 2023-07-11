package PhaseOne.Beginner.interface_7.basics3;

public class MysqlDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("Connect mysql");
    }

    @Override
    public void close() {
        System.out.println("Close mysql");
    }
}
