package com.study.design.order.pojo;

/**
 * @description: 订单状态
 * @author： 灰原二
 * @date: 2022/11/13 10:04
 */
public enum OrderState {
    TO_PAID, //待支付
    TO_SEND,//待发货
    TO_RECEIVE,//待收货
    COMPLETED,//订单完成
    ;
}
