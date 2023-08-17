package jdbc_._6_preparedStatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementDML_ {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输删除管理员的名字: ");
        String admin_name = scanner.nextLine();
//        System.out.print("请输入管理员的新密码: ");
//        String admin_pwd = scanner.nextLine();

        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1. 注册驱动
        Class.forName(driver);//建议写上

        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3. 得到PreparedStatement
        //String sql = "insert into admin values(?, ?)";
        //String sql = "update admin set pwd = ? where name = ?";
        String sql = "delete from  admin where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, admin_name);
        //preparedStatement.setString(2, admin_name);

        //4. 执行 dml 语句使用  executeUpdate
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");

        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
