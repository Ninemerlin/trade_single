package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.OrderService;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/getOrder")
    public Result getOrder(){
        Long userId = UserContext.getUser();
        System.out.println("[OrderService] GetOrder : userId " + userId);
        Result result = orderService.getOrder(userId);
        if(result.getCode() == 200){
            System.out.println("[OrderService] GetOrder Succeeded.");
            return result;
        }
        System.out.println("[OrderService] GetOrder Failed.");
        return result;
    }

    @PostMapping("/createOrder")
    public Result createOrder(){
        Long userId = UserContext.getUser();
        System.out.println("[OrderService] CreateOrder : userId " + userId);
        Result result = orderService.getOrder(userId);
        if(result.getCode() == 200){
            System.out.println("[OrderService] CreateOrder Succeeded.");
            return result;
        }
        System.out.println("[OrderService] CreateOrder Failed.");
        return result;
    }
}
