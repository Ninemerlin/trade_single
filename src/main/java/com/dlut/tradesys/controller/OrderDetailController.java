package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.OrderDetailService;
import com.dlut.tradesys.service.impl.OrderDetailServiceImpl;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orderDetail")
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @GetMapping("/getOrderDetail/{orderId}")
    public Result getOrderDetail(@PathVariable Long orderId){
        Long userId = UserContext.getUser();
        System.out.println("[OrderDetailService] GetOrderDetail : userId " + userId + " orderId " + orderId);
        Result result = orderDetailService.getOrderDetail(orderId);
        if(result.getCode() == 200){
            System.out.println("[OrderDetailService] GetOrderDetail Succeeded.");
            return result;
        }
        System.out.println("[OrderDetailService] GetOrderDetail Failed.");
        return result;
    }
}
