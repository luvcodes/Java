package cn.itcast.hotel.pojo;

import lombok.Data;

/**
 * @author ryanw
 */
@Data
public class RequestParams {
    private String key;
    private Integer page;
    private Integer size;
    private String sortBy;
}