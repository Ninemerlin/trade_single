package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.ShopService;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shop")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping("/getShop")
    public Result getShop() {
        Long userId = UserContext.getUser();
        System.out.println("[ShopService] GetShop : userId " + userId);
        Result result = shopService.getShop(userId);
        if(result.getCode() == 200){
            System.out.println("[ShopService] GetShop Succeeded.");
            return result;
        }
        System.out.println("[ShopService] GetShop Failed.");
        return result;
    }

    @PostMapping("/addShop")
    public Result addShop(String name) {
        Long userId = UserContext.getUser();
        System.out.println("[ShopService] AddShop : userId " + userId);
        Result result = shopService.addShop(userId, name);
        if(result.getCode() == 200){
            System.out.println("[ShopService] AddShop Succeeded.");
            return result;
        }
        System.out.println("[ShopService] AddShop Failed.");
        return result;
    }

    @PutMapping("/modifyShop")
    public Result modifyShop(Long shopId, String name) {
        Long userId = UserContext.getUser();
        System.out.println("[ShopService] ModifyShop : userId " + userId);
        Result result = shopService.modifyShop(shopId, name);
        if(result.getCode() == 200){
            System.out.println("[ShopService] Shop Modification Succeeded.");
            return result;
        }
        System.out.println("[ShopService] Shop Modification Failed.");
        return result;
    }

    @DeleteMapping("/deleteShop/{shopId}")
    public Result deleteShop(@PathVariable Integer shopId) {
        Long userId = UserContext.getUser();
        System.out.println("[ShopService] DeleteShop : userId " + userId);
        Result result = shopService.deleteShop(shopId);
        if(result.getCode() == 200){
            System.out.println("[ShopService] DeleteShop Succeeded.");
            return result;
        }
        System.out.println("[ShopService] DeleteShop Failed.");
        return result;
    }
}
