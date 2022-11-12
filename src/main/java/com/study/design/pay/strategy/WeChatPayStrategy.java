package com.study.design.pay.strategy;

import com.study.design.pay.PayStrategy;
import com.study.design.pay.pojo.PayBody;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 10:15
 */
public class WeChatPayStrategy implements PayStrategy {
    @Override
    public boolean pay(PayBody payBody) {
        System.out.println("微信支付成功");
        return true;
    }
}
