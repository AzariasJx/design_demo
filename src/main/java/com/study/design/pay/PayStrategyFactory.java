package com.study.design.pay;

import com.study.design.pay.PayStrategy;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 10:21
 */
public class PayStrategyFactory {

    public static PayStrategy getPayStrategy(PayStrategyEnum payStrategyEnum){
        PayStrategy payStrategy = null;

        try {
            payStrategy = (PayStrategy) payStrategyEnum.getClazz().newInstance();
        } catch (Exception e) {

            //ignore
        }


        return payStrategy;
    }

}
