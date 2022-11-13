package com.study.design.pay;

import com.study.design.pay.pojo.PayBody;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 15:49
 */
public abstract class AbstractPayContext {
    public abstract boolean execute(PayBody payBody);
}
