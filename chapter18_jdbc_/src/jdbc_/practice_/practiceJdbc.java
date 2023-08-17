package jdbc_.practice_;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

@SuppressWarnings({"all"})
public class practiceJdbc {
    @Test
    public void connect() throws IOException, ClassNotFoundException, SQLException {
        // 使用Properties对象获得配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        // 获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 注册驱动 可以不加
        Class.forName(driver);

        // 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Use 5th method = " + connection);
        // add 5 records to the database
        String sql1 = "insert into actor values (1, 'mark')";
        String sql2 = "insert into actor values (2, 'bill')";
        String sql3 = "insert into actor values (3, 'daisy')";
        String sql4 = "insert into actor values (4, 'Scott')";
        String sql5 = "insert into actor values (5, 'Manny')";
        // update the record that id = 1, change name into my name
        String updateSQL = "update actor set name = 'ryan' where id = 1";
        // delete the record that id = 3
        String deleteSQL = "delete from actor where id = 3";

        Statement statement = connection.createStatement();
//        int rows1 = statement.executeUpdate(sql1);
//        int rows2 = statement.executeUpdate(sql2);
//        int rows3 = statement.executeUpdate(sql3);
//        int rows4 = statement.executeUpdate(sql4);
//        int rows5 = statement.executeUpdate(sql5);
//        int rows6 = statement.executeUpdate(updateSQL); // assign the updateSQL statement
//        int rows7 = statement.executeUpdate(deleteSQL); // assign the deleteSQL statement

//        System.out.println(rows1 > 0 ? "第一条数据插入成功" : "第一条数据插入失败");
//        System.out.println(rows2 > 0 ? "第二条数据插入成功" : "第二条数据插入失败");
//        System.out.println(rows3 > 0 ? "第三条数据插入成功" : "第三条数据插入失败");
//        System.out.println(rows4 > 0 ? "第四条数据插入成功" : "第四条数据插入失败");
//        System.out.println(rows5 > 0 ? "第五条数据插入成功" : "第五条数据插入失败");
//        System.out.println(rows6 > 0 ? "修改成功" : "修改失败");
//        System.out.println(rows7 > 0 ? "删除成功" : "删除失败");

        statement.close();
        connection.close();
    }
}
