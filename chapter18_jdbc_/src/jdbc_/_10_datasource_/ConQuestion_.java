package jdbc_._10_datasource_;

import jdbc_._7_utils_.JDBCUtils;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
public class ConQuestion_ {
    //代码 连接mysql 5000次
    @Test
    public void testCon() {
        //看看连接-关闭 connection 会耗用多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接.....");
        for (int i = 0; i < 5000; i++) {
            //使用传统的jdbc方式，得到连接
            Connection connection = JDBCUtils.getConnection();

            //做一些工作，比如得到PreparedStatement ，发送sql
            //..........

            //关闭。如果不关闭就会抛出异常
            JDBCUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        //传统方式5000次
        System.out.println("传统方式5000次 耗时=" + (end - start));
    }
}
