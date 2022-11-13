package com.study.design.controller;

import com.study.design.order.pojo.Order;
import com.study.design.service.OrderService;
import com.study.design.pay.pojo.PayBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 9:09
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public Order createOrder(@RequestParam Integer orderId){
        return orderService.createOrder(orderId);
    }
    @RequestMapping("/payOrder")
    public Order pay(@RequestBody PayBody payBody){
        return orderService.pay(payBody);
    }

    @RequestMapping("/deliveryOrder")
    public Order pay(@RequestParam Integer orderId){
        return orderService.deliveryOrder(orderId);
    }

    @RequestMapping("/receiveOrder")
    public Order receiveOrder(@RequestParam Integer orderId){
        return orderService.reveiveOrder(orderId);
    }

}
