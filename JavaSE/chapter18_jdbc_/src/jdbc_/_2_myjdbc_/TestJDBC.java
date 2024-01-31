package jdbc_._2_myjdbc_;

public class TestJDBC {
    public static void main(String[] args) {
        JdbcInerface jdbcInerface = new MySQLJdbcImple();
        jdbcInerface.getConnection();
        jdbcInerface.crud();
        jdbcInerface.close();

        System.out.println("==========================");
        jdbcInerface = new OracleJdbcSimple();
        jdbcInerface.getConnection();
        jdbcInerface.crud();
        jdbcInerface.close();
    }
}
