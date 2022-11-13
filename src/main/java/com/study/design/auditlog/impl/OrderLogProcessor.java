package com.study.design.auditlog.impl;

import com.study.design.auditlog.AbstractAuditLogProcessor;
import com.study.design.auditlog.AuditLog;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 20:45
 */
@Component
public class OrderLogProcessor extends AbstractAuditLogProcessor {
    @Override
    protected AuditLog buildDetails(AuditLog log) {
        String orderId = log.getOrderId();
        String orderDetails = "通过orderid获取订单明细";
        log.setDetail(orderDetails);
        return log;
    }
}