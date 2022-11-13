package com.study.design.pay.decorator;

import com.study.design.pay.AbstractPayContext;
import com.study.design.pay.pojo.PayBody;

/**
 * @description: 支付装饰器
 * @author： 灰原二
 * @date: 2022/11/13 15:53
 */
public class PayDecorator extends AbstractPayDecorator{

    public PayDecorator(AbstractPayContext abstractPayContext) {
        super(abstractPayContext);
    }

    @Override
    public boolean addUserResource(PayBody payBody){
        super.execute(payBody);
        String product = payBody.getProduct();
        System.out.println("为用户添加优惠券和平台积分");
        return true;
    }
}
