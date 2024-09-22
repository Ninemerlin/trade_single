package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.ItemService;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
