package org.example.dto;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.domain.User;

/**
 * @author ryanw
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
