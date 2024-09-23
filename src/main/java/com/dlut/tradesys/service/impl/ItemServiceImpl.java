package com.dlut.tradesys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.dlut.tradesys.common.dto.ItemFormDTO;
import com.dlut.tradesys.common.enums.ItemStatus;
import com.dlut.tradesys.common.pojo.Item;
import com.dlut.tradesys.common.pojo.PageBean;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.ItemMapper;
import com.dlut.tradesys.service.ItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;

    @Override
    public Result itemSearch(Integer pageSize, Integer currentPage, String keyword, String category, String orderBy, Long shopId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Item> itemList = itemMapper.itemSearch(keyword, category, orderBy, 1, shopId);
        Page<Item> p = (Page<Item>)itemList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getPageSize(),p.getPageNum(),p.getPages(),p.getResult());
        return Result.success().addMsg("商品查询成功.").addData("itemPages", pageBean);
    }

    @Override
    public Result addItem(ItemFormDTO form) {
        Item item = BeanUtil.copyProperties(form, Item.class);
        item.setCreateTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        item.setStatus(ItemStatus.NORMAL);
        item.setSold(0);
        System.out.println(item.toString());
        if(itemMapper.addItem(item)) {
            return Result.success().addMsg("商品添加成功.");
        }
        return Result.fail().addMsg("商品添加失败.");
    }

    @Override
    public Result modifyItem(Item item) {
        item.setUpdateTime(LocalDateTime.now());
        System.out.println(item.toString());
        if(itemMapper.modifyItem(item)) {
            return Result.success().addMsg("商品修改成功.");
        }
        return Result.fail().addMsg("商品修改失败.");
    }

    @Override
    public Result deleteItem(Long itemId) {
        if(itemMapper.deleteItem(itemId)) {
            return Result.success().addMsg("商品删除成功.");
        }
        return Result.fail().addMsg("商品删除失败.");
    }

    @Override
    public boolean deductStockAndIncreaseSold(Long itemId, Integer amount) {
        Integer stock = itemMapper.getStockById(itemId);
        Integer sold = itemMapper.getSoldById(itemId);
        return itemMapper.setStockAndSold(itemId, stock - amount, sold + amount);
    }

    @Override
    public boolean increaseStockAndDeductSold(Long itemId, Integer amount) {
        Integer stock = itemMapper.getStockById(itemId);
        Integer sold = itemMapper.getSoldById(itemId);
        return itemMapper.setStockAndSold(itemId, stock + amount, sold - amount);
    }
}
