package com.study.design.pay;

import com.study.design.pay.pojo.PayBody;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 10:14
 */
public interface PayStrategy {

    boolean pay(PayBody payBody);
}
