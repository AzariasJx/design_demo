package com.study.design.pay;

import com.study.design.pay.pojo.PayBody;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 10:14
 */
public class PayContext {
    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public boolean execute(PayBody payBody){
        return payStrategy.pay(payBody);
    }
}
