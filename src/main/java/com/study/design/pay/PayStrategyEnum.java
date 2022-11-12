package com.study.design.pay;

import com.study.design.pay.strategy.AlipayPayStrategy;
import com.study.design.pay.strategy.WeChatPayStrategy;

import java.util.Arrays;
import java.util.Map;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 10:31
 */
public enum PayStrategyEnum {
    ALIPAY(1, AlipayPayStrategy.class),
    WECHAT(2, WeChatPayStrategy.class),
    ;

    private int type;

    private Class clazz;

    PayStrategyEnum(int type,Class<?> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public static PayStrategyEnum getByType(int type){

        for (PayStrategyEnum value : values()) {
            if(value.getType()==type){
                return value;
            }
        }
        return null;

    }
}
