package com.study.design.auditlog;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 20:36
 */
public class AuditLog {
    private  String account;
    private String action;
    private String orderId;

    //可变对象，实际日志类型的类型实例
    private Object detail;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }


    @Override
    public String toString() {
        return "AuditLog{" +
                "account='" + account + '\'' +
                ", action='" + action + '\'' +
                ", orderId='" + orderId + '\'' +
                ", detail=" + detail +
                '}';
    }
}
