package com.study.design.pay;

import com.study.design.pay.pojo.PayBody;

/**
 * @description:支付上下文
 * @author： 灰原二
 * @date: 2022/11/12 10:14
 */
//装饰器模式：支付上下文就是我们的被装饰者，因为我们想给payContext添加额外功能：平台币或者发放红包
public class PayContext extends AbstractPayContext{
    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    @Override
    public boolean execute(PayBody payBody){
        return payStrategy.pay(payBody);
    }
}
