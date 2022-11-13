package com.study.design.order.pojo;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 10:04
 */
public class Order {
    private int orderId;
    private OrderState orderState;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
