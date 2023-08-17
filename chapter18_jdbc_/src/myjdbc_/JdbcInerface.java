package myjdbc_;

public interface JdbcInerface {
    //连接
    public Object getConnection();
    //crud
    public void crud();
    //关闭连接
    public void close();
}