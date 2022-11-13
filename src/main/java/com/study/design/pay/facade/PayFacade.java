package com.study.design.pay.facade;

import com.study.design.pay.PayContext;
import com.study.design.pay.PayStrategy;
import com.study.design.pay.PayStrategyEnum;
import com.study.design.pay.PayStrategyFactory;
import com.study.design.pay.decorator.PayDecorator;
import com.study.design.pay.pojo.PayBody;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 10:46
 */
public class PayFacade {

    public Boolean pay(PayBody payBody){

        PayStrategy payStrategy = PayStrategyFactory.getPayStrategy(PayStrategyEnum.getByType(payBody.getType()));
        PayDecorator payDecorator = new PayDecorator(new PayContext(payStrategy));
        return payDecorator.addUserResource(payBody);
    }
}
