package com.study.design.auditlog;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 20:39
 */
public abstract class AbstractAuditLogProcessor {

    public final AuditLog buildAuditLogCommon(String account,String action,String orderId){
        AuditLog auditLog = new AuditLog();
        auditLog.setAccount(account);
        auditLog.setAction(action);
        auditLog.setOrderId(orderId);
        return auditLog;
    }

    protected abstract AuditLog buildDetails(AuditLog log);

    public final void sendToQueue(AuditLog auditLog){
        System.out.println("已经发送到MQ中了,日志内容是："+auditLog.toString());
    }

    public final void processAuditLog(String account,String action,String orderId){
        this.sendToQueue(buildDetails(buildAuditLogCommon(account,action,orderId)));
    }
}
