package com.study.design.order.pojo;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 10:04
 */
public class Order {
    private Integer orderId;
    private OrderState orderState;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
