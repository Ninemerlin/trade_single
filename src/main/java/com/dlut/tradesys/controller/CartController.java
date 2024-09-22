package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.dto.ItemFormDTO;
import com.dlut.tradesys.common.pojo.Cart;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.CartService;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
@Slf4j
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/getCart")
    public Result getCart() {
        Long userId = UserContext.getUser();
        System.out.println("[CartService] GetCart : userId " + userId);
        Result result = cartService.getCart(userId);
        if(result.getCode() == 200){
            System.out.println("[CartService] GetCart Succeeded.");
            return result;
        }
        System.out.println("[CartService] GetCart Failed.");
        return result;
    }

    @PostMapping("/addCart")
    public Result addCart(@RequestBody Cart cart) {
        Long userId = UserContext.getUser();
        System.out.println("[CartService] AddCart : userId " + userId);
        Result result = cartService.addCart(userId, cart);
        if(result.getCode() == 200){
            System.out.println("[CartService] AddCart Succeeded.");
            return result;
        }
        System.out.println("[CartService] AddCart Failed.");
        return result;
    }
}
