package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.dto.ItemFormDTO;
import com.dlut.tradesys.common.pojo.Item;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.ItemService;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/item")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/itemSearch")
    public Result itemSearch(Integer pageSize, Integer currentPage, String keyword, String category, String orderBy, Long shopId) {
        Long userId = UserContext.getUser();
        System.out.println("[ItemService] ItemSearch : userId " + userId);
        Result result = itemService.itemSearch(pageSize, currentPage, keyword, category, orderBy, shopId);
        if(result.getCode() == 200){
            System.out.println("[ItemService] ItemSearch Succeeded.");
            return result;
        }
        System.out.println("[ItemService] ItemSearch Failed.");
        return result;
    }

    @PostMapping("/addItem")
    public Result addItem(@RequestBody ItemFormDTO form) {
        Long userId = UserContext.getUser();
        System.out.println("[ItemService] AddItem : userId " + userId);
        Result result = itemService.addItem(form);
        if(result.getCode() == 200){
            System.out.println("[ItemService] AddItem Succeeded.");
            return result;
        }
        System.out.println("[ItemService] AddItem Failed.");
        return result;
    }

    @PutMapping("/modifyItem")
    public Result modifyItem(@RequestBody Item item) {
        Long userId = UserContext.getUser();
        System.out.println("[ItemService] Item Modification : userId " + userId);
        Result result = itemService.modifyItem(item);
        if(result.getCode() == 200){
            System.out.println("[ItemService] Item Modification Succeeded.");
            return result;
        }
        System.out.println("[ItemService] AddItem Modification Failed.");
        return result;
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public Result deleteItem(@PathVariable Long itemId) {
        Long userId = UserContext.getUser();
        System.out.println("[ItemService] DeleteItem : userId " + userId + " itemId " + itemId);
        Result result = itemService.deleteItem(itemId);
        if(result.getCode() == 200){
            System.out.println("[ItemService] DeleteItem Succeeded.");
            return result;
        }
        System.out.println("[ItemService] DeleteItem Failed.");
        return result;
    }
}
