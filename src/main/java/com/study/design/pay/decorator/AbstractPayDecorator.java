package com.study.design.pay.decorator;

import com.study.design.pay.AbstractPayContext;
import com.study.design.pay.pojo.PayBody;
import com.study.design.pojo.UserInfo;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 15:52
 */
public abstract class AbstractPayDecorator {
    private AbstractPayContext abstractPayContext;

    public AbstractPayDecorator(AbstractPayContext abstractPayContext) {
        this.abstractPayContext = abstractPayContext;
    }

    public boolean execute(PayBody payBody){
        return abstractPayContext.execute(payBody);
    }

    protected abstract boolean addUserResource(PayBody payBody);
}
