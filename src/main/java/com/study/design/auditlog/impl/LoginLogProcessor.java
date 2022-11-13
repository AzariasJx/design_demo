package com.study.design.auditlog.impl;

import com.study.design.auditlog.AbstractAuditLogProcessor;
import com.study.design.auditlog.AuditLog;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/13 20:44
 */
@Component
public class LoginLogProcessor extends AbstractAuditLogProcessor {
    @Override
    protected AuditLog buildDetails(AuditLog log) {
        return log;
    }
}
