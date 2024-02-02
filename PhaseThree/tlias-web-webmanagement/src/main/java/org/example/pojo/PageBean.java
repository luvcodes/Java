package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author ryanw
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    // 总记录数
    private Long total;
    // 数据列表
    private List rows;
}
