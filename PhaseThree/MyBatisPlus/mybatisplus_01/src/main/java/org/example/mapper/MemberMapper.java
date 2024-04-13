package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.domain.Member;

/**
 * @author ryanw
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}
