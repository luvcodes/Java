package dao_.test;

import dao_.dao.ActorDAO;
import dao_.dao.GoodsDAO;
import dao_.domain.Actor;
import dao_.domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;
public class TestDAO {
    //测试ActorDAO 对actors表crud操作
    @Test
    public void testActorDAO() {
//        ActorDAO actorDAO = new ActorDAO();
//        //1. 查询
//        List<Actor> actors = actorDAO.queryMulti("select * from actors where id >= ?", Actor.class, 1);
//        System.out.println("===查询结果===");
//        for (Actor actor : actors) {
//            System.out.print(actor);
//            System.out.println();
//        }
//
//        //2. 查询单行记录
//        Actor actor = actorDAO.querySingle("select * from actors where id = ?", Actor.class, 6);
//        System.out.println("====查询单行结果====");
//        System.out.println(actor);
//
//        //3. 查询单行单列
//        Object o = actorDAO.queryScalar("select name from actors where id = ?", 1);
//        System.out.println("====查询单行单列值===");
//        System.out.println(o);
//
//        //4. dml操作  insert ,update, delete
//        int update = actorDAO.update("insert into actors values(null, ?, ?, ?, ?)", "张无忌", "男", "2000-11-11", "999");
//        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");


        // Test GoodsDAO - conduct CRUD operations
        GoodsDAO goodsDAO = new GoodsDAO();

        // dml操作 insert
//        int update = goodsDAO.update("insert into goods values (null, ?, ?)", "小米手机", 2000);
//        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");

        // 查询
        List<Goods> goodsList = goodsDAO.queryMulti("select * from goods where id >= ?", Goods.class, 1);
        System.out.println("Multiple select results");
        for (Goods goods : goodsList) {
            System.out.println(goods);
            System.out.println();
        }

        Goods querySingle = goodsDAO.querySingle("select * from goods where id = ?", Goods.class, 1);
        System.out.println("Single select result");
        System.out.println(querySingle);

        Object queryScalar = goodsDAO.queryScalar("select price from goods where id = ?", 1);
        System.out.println("Single attribute result");
        System.out.println(queryScalar);
    }
}
