package PhaseOne.Beginner.interface_7.basics3;

public class OracleDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("Oracle DB connection");
    }    

    @Override
    public void close() {
        System.out.println("Oracle DB close");
    }
}
