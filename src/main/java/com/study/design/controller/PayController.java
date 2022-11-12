package com.study.design.controller;

import com.study.design.service.PayService;
import com.study.design.pay.pojo.PayBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 9:09
 */
@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @RequestMapping("/pay")
    public Boolean pay(@RequestBody PayBody payBody){
        return payService.pay(payBody);

    }
}
