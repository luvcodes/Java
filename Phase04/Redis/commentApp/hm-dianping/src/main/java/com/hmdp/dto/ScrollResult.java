package com.hmdp.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ryanw
 * 滚动分页实体类
 */
@Data
public class ScrollResult {
    private List<?> list;
    private Long minTime;
    private Integer offset;
}
