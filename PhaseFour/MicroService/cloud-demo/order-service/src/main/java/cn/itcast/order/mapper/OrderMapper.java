package cn.itcast.order.mapper;

import cn.itcast.order.pojo.Order;
import org.apache.ibatis.annotations.Select;

/**
 * @author ryanw
 */
public interface OrderMapper {
    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
