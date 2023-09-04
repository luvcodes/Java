package jdbc_._10_datasource_;

import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings({"all"})
public class JDBCUtilsByDruid_USE {

    @Test
    public void testSelect() {
        System.out.println("使用 druid方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "select * from actors where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass()); // 运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1); // 给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();

            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }

    //使用土方法来解决ResultSet = 封装=> Arraylist
    @Test
    public void testSelectToArrayList() {
        System.out.println("使用 druid方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "select * from actors where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<>();//创建ArrayList对象,存放actor对象
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            //运行类型 com.alibaba.druid.pool.DruidPooledConnection
            // System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                //把得到的resultset 的记录，封装到 Actor对象，放入到list集合
                list.add(new Actor(id, name, sex, borndate, phone));
            }

            System.out.println("list集合数据=" + list);

            // 这里可以使用getId和getName方法的原因是因为在Actor类中定义了getters
            for(Actor actor : list) {
                System.out.println("id=" + actor.getId() + "\t" + actor.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
        /**
         * 这里可以把方法的返回类型定义成ArrayList<Actor>，而且是可以断掉连接的。因为已经把Actors表的数据封装到ArrayList中了，在这里
         * 是list。所以最后的返回值就直接返回list就可以。这样其他的方法想要调用这个表中的数据的时候，直接调用这个方法就可以。ArrayList
         * 跟这个连接是没有关系的，因为ArrayList 和 connection 没有任何关联，所以该集合可以复用.
         * */
//        return list;
    }
}
