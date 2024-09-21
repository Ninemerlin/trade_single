package com.dlut.tradesys.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;
    private Integer size;
    private Integer current;
    private Integer pages;
    private List<Item> rows;
}
