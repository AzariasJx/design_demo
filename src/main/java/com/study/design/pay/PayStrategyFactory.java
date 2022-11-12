package com.study.design.pay;

import com.study.design.pay.PayStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 10:21
 */
public class PayStrategyFactory {
    //单例模式优化工厂返回支付策略
    private static final Map<String,PayStrategy> strategyMap = new ConcurrentHashMap<>();

    public static PayStrategy getPayStrategy(PayStrategyEnum payStrategyEnum){

        PayStrategy payStrategy = strategyMap.get(payStrategyEnum.getClazz().getName());
        if(null == payStrategy){
            try {
                payStrategy = (PayStrategy) payStrategyEnum.getClazz().newInstance();
                strategyMap.put(payStrategy.getClass().getName(),payStrategy);
            } catch (Exception e) {
                //ignore
            }
        }




        return payStrategy;
    }

}
