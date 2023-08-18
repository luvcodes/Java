package jdbc_._6_preparedStatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class practicePreparedStatement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        /**
         * 1. 创建admin表
         * 2. 使用preparedStatement添加5条数据
         * 3. 修改tom的记录，将name改成king
         * 4. 删除一条记录
         * 5 查询全部记录，并显示在控制台
         * */
        Scanner scanner = new Scanner(System.in);
        // for insert
//        System.out.print("Please enter the name of the new admin: ");
//        String admin_name = scanner.nextLine();
//        System.out.print("Please enter the password of the new admin: ");
//        String admin_pwd = scanner.nextLine();
//        System.out.println();

        // for update
//        System.out.print("Please enter the new name of the admin: ");
//        String admin_name = scanner.nextLine();
//        System.out.print("Please enter the name of the admin: ");
//        String admin_newName = scanner.nextLine();
//        System.out.println();

        System.out.print("Please enter the name of the admin you want to delete: ");
        String admin_name = scanner.nextLine();
        System.out.println();

        // 通过properies对象获得配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 1. 注册驱动
        Class.forName(driver);

        // 2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3. 得到preparedStatement
        String insertSql = "insert into admin values (?, ?)";
        String updateSql = "update admin set `name` = ? where `name` = ?";
        String deleteSql = "delete from admin where `name` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);

//        preparedStatement.setString(1, admin_name);
//        preparedStatement.setString(2, admin_pwd);

//        preparedStatement.setString(1, admin_name);
//        preparedStatement.setString(2, admin_newName);

        preparedStatement.setString(1, admin_name);

        // 4. 执行 dml 语句使用  executeUpdate
        int rows1 = preparedStatement.executeUpdate();
        System.out.println(rows1 > 0 ? "Execute success" : "Execute failed");


        // 5. 关闭连接
        preparedStatement.close();
        connection.close();
    }
}
