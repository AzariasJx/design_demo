package com.study.design.order;

import com.study.design.order.pojo.Order;
import com.study.design.order.pojo.OrderState;
import com.study.design.order.pojo.OrderStateChangeAction;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 10:44
 */
@Component("orderStateListener")
@WithStateMachine(name = "orderStateMachine")
public class OrderStateListener {
    @OnTransition(source = "TO_PAID",target = "TO_SEND")
    public boolean payToSend(Message<OrderStateChangeAction> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.TO_SEND);
        return true;
    }

    @OnTransition(source = "TO_SEND",target = "TO_RECEIVE")
    public boolean sendToReceive(Message<OrderStateChangeAction> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.TO_RECEIVE);
        return true;
    }
    @OnTransition(source = "TO_RECEIVE",target = "COMPLETED")
    public boolean receiveToComplete(Message<OrderStateChangeAction> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.COMPLETED);
        return true;
    }

}
