package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.dto.OrderFormDTO;
import com.dlut.tradesys.common.pojo.Address;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.OrderService;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result createOrder(@RequestBody List<OrderFormDTO> formList){
        Long userId = UserContext.getUser();
        System.out.println("[OrderService] CreateOrder : userId " + userId);
        int i = 0;
        for (OrderFormDTO form : formList){
            i++;
            Result result = orderService.createOrder(userId, form);
            if(result.getCode() == 200){
                System.out.println("[OrderService] CreateOrder " + i + " Succeeded.");
            } else {
                System.out.println("[OrderService] CreateOrder " + i + " Failed.");
                return result;
            }
        }
        System.out.println("[OrderService] CreateAllOrders Completed.");
        return Result.success().addMsg(i + "个订单创建成功.");
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public Result deleteOrder(@PathVariable Long orderId) {
        Long userId = UserContext.getUser();
        System.out.println("[OrderService] DeleteOrder : userId " + userId + " orderId " + orderId);
        Result result = orderService.deleteOrder(orderId);
        if(result.getCode() == 200){
            System.out.println("[OrderService] DeleteOrder Succeeded.");
            return result;
        }
        System.out.println("[OrderService] DeleteOrder Failed.");
        return result;
    }

    @PutMapping("/setOrderStatus/{orderId}/{status}")
    public Result setOrderStatus(@PathVariable Long orderId, @PathVariable Integer status) {
        Long userId = UserContext.getUser();
        System.out.println("[OrderService] SetOrderStatus : userId " + userId + " orderId " + orderId + " status " + status);
        Result result = orderService.setOrderStatus(orderId, status);
        if(result.getCode() == 200){
            System.out.println("[OrderService] SetOrderStatus Succeeded.");
            return result;
        }
        System.out.println("[OrderService] SetOrderStatus Failed.");
        return result;
    }
}
