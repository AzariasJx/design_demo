package com.study.design.order.pojo;

/**
 * @description: 订单状态转换操作
 * @author： 灰原二
 * @date: 2022/11/13 10:06
 */
public enum OrderStateChangeAction {
    PAY_ORDER, //支付
    DELIVERY_ORDER,//发货
    RECEIVE_ORDER, //收货
}
