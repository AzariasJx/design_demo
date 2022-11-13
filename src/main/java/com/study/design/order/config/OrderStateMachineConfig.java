package com.study.design.order.config;

import com.study.design.order.pojo.Order;
import com.study.design.order.pojo.OrderState;
import com.study.design.order.pojo.OrderStateChangeAction;
import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

/**
 * @description: 支付订单状态机配置
 * @author： 灰原二
 * @date: 2022/11/13 10:20
 */
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderStateChangeAction> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderStateChangeAction> states) throws Exception {
        //初始化订单状态
        states.withStates().initial(OrderState.TO_PAID)
                .states(EnumSet.allOf(OrderState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderStateChangeAction> transitions) throws Exception {
        //状态机流程配置
        transitions
                .withExternal().source(OrderState.TO_PAID)
                .target(OrderState.TO_SEND)
                .event(OrderStateChangeAction.PAY_ORDER)
                .and()
                .withExternal().source(OrderState.TO_SEND)
                .target(OrderState.TO_RECEIVE)
                .event(OrderStateChangeAction.DELIVERY_ORDER)
                .and()
                .withExternal().source(OrderState.TO_RECEIVE)
                .target(OrderState.COMPLETED)
                .event(OrderStateChangeAction.RECEIVE_ORDER);
    }

    @Bean
    public DefaultStateMachinePersister machinePersister(){

        return new DefaultStateMachinePersister(new StateMachinePersist<Object,Object, Order>() {
            @Override
            public void write(StateMachineContext<Object, Object> stateMachineContext, Order order) throws Exception {
                //数据持久化
            }

            @Override
            public StateMachineContext<Object, Object> read(Order order) throws Exception {
                return new DefaultStateMachineContext<>(order.getOrderState(),null,null,null);
            }
        });
    }
}
