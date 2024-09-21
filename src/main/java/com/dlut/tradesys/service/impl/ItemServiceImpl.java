package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.pojo.Item;
import com.dlut.tradesys.common.pojo.PageBean;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.ItemMapper;
import com.dlut.tradesys.service.ItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;

    @Override
    public Result itemSearch(Integer pageSize, Integer currentPage, String keyword, String category, String orderBy) {
        PageHelper.startPage(currentPage, pageSize);
        List<Item> itemList = null;
        if("".equals(category)){
            itemList = itemMapper.itemSearch(keyword, orderBy);
        } else {
            itemList = itemMapper.itemSearchWithCategory(keyword, category, orderBy);
        }
        Page<Item> p = (Page<Item>)itemList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getPageSize(),p.getPageNum(),p.getPages(),p.getResult());
        return Result.success().addMsg("商品查询成功.").addData("itemPages", pageBean);
    }
}
