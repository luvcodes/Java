package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.domain.User;

/**
 * @author ryanw
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
