package com.study.design.service;

import com.study.design.pay.PayContext;
import com.study.design.pay.PayStrategyEnum;
import com.study.design.pay.PayStrategyFactory;
import com.study.design.pay.facade.PayFacade;
import com.study.design.pay.pojo.PayBody;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 9:37
 */
@Service
public class PayService {

    public Boolean pay(PayBody payBody){
        PayFacade payFacade = new PayFacade();
        return payFacade.pay(payBody);
    }

}
