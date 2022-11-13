package com.study.design.service;

import com.study.design.auditlog.impl.OrderLogProcessor;
import com.study.design.order.pojo.Order;
import com.study.design.order.pojo.OrderState;
import com.study.design.order.pojo.OrderStateChangeAction;
import com.study.design.pay.facade.PayFacade;
import com.study.design.pay.pojo.PayBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 9:37
 */
@Service
public class OrderService {

    @Resource
    private StateMachine<OrderState,OrderStateChangeAction> orderStateMachine;

    @Resource
    private StateMachinePersister<OrderState,OrderStateChangeAction,Order> stateMachinePersister;

    @Autowired
    private OrderLogProcessor orderLogProcessor;

    //模拟数据持久化
    private static List<Order> orders = new ArrayList<>();

    public Order createOrder(Integer orderId){
        Order order = new Order();
        order.setOrderState(OrderState.TO_PAID);
        order.setOrderId(orderId);

        orders.add(order);
        orderLogProcessor.processAuditLog("用户名称","创建订单",orderId.toString());
        return order;
    }

    public Order pay(PayBody payBody){
        PayFacade payFacade = new PayFacade();
        Boolean flag = payFacade.pay(payBody);
        if(flag){
            Order order = orders.get(0);
            Message<OrderStateChangeAction> message = MessageBuilder
                    .withPayload(OrderStateChangeAction.PAY_ORDER)
                    .setHeader("order",order)
                    .build();

            //如果流转成功
            if(changeStateAction(message,order)){
                return order;
            }

        }
        return null;
    }


    public Order deliveryOrder(Integer orderId){
        Order order = orders.get(0);
        Message<OrderStateChangeAction> message = MessageBuilder
                .withPayload(OrderStateChangeAction.DELIVERY_ORDER)
                .setHeader("order",order)
                .build();
        //如果流转成功
        if(changeStateAction(message,order)){
            return order;
        }

        return order;
    }

    public Order reveiveOrder(Integer orderId){
        Order order = orders.get(0);
        Message<OrderStateChangeAction> message = MessageBuilder
                .withPayload(OrderStateChangeAction.RECEIVE_ORDER)
                .setHeader("order",order)
                .build();
        //如果流转成功
        if(changeStateAction(message,order)){
            return order;
        }

        return order;
    }

    private boolean changeStateAction(Message<OrderStateChangeAction> message,Order order){
        try{
            orderStateMachine.start();
            stateMachinePersister.restore(orderStateMachine,order);
            boolean result = orderStateMachine.sendEvent(message);
            stateMachinePersister.persist(orderStateMachine,order);
            return result;
        }catch (Exception e){

        }finally {
            orderStateMachine.stop();
        }
        return false;
    }
}
