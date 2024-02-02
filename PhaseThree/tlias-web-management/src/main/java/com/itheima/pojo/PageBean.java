package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 分页查询结果封装类
 * @author ryanw
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    //总记录数
    private Long total;
    //当前页数据列表
    private List rows;
}