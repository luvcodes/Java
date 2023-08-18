package jdbc_._8_transaction_;

import jdbc_._7_utils_.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction_ {
    //没有使用事务.
    @Test
    public void noTransaction() {
        //操作转账的业务
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "update accounts set balance = balance - 100 where id = 1";
        String sql2 = "update accounts set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建PreparedStatement 对象
        try {
            /**
             * 出现id=1的行的balance减了100，而id=2行的balance没有变化的原因是什么？
             * 因为在默认情况下，connection是默认自动提交，第一条sql使用executeUpdate方法之后就直接提交了，数据库发生改变
             * 但是由于下面的1/0的运算，又导致抛出异常，那么这一行代码下面的代码就不再执行
             * */
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第1条sql

            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第2条sql
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //事务来解决
    @Test
    public void useTransaction() {
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "update accounts set balance = balance - 100 where id = 1";
        String sql2 = "update accounts set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. 创建PreparedStatement 对象
        try {
            // 在默认情况下，connection是默认自动提交
            connection = JDBCUtils.getConnection();
            /**
             * 将 connection 设置为不自动提交
             * 相当于开启了事务
             * */
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第1条sql

//            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第2条sql

            //这里提交事务
            connection.commit();

        } catch (SQLException e) {
            // 这里我们可以进行回滚，即撤销执行的SQL
            // 默认回滚到事务开始的状态.
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
