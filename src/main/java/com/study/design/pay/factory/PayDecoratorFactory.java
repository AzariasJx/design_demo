package com.study.design.pay.factory;

import com.study.design.pay.PayContext;
import com.study.design.pay.PayStrategy;
import com.study.design.pay.decorator.PayDecorator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 18:17
 */
public class PayDecoratorFactory {

    private final static Map<PayStrategy, PayDecorator> payDecoratorMaps = new ConcurrentHashMap<>();

    public static PayDecorator getPayDecorator(PayStrategy payStrategy){

        if(!payDecoratorMaps.containsKey(payStrategy)){

            payDecoratorMaps.put(payStrategy,new PayDecorator(new PayContext(payStrategy)));

        }
        return payDecoratorMaps.get(payStrategy);
    }
}
