package com.study.design.handler;

import com.study.design.pojo.UserInfo;

import java.util.List;

/**
 * @description: 抽象投放
 * @author： 灰原二
 * @date: 2022/11/12 21:57
 */
public interface SuggestRequirementHandler {
    /**
     * 执行过滤
     * @param userInfo
     * @param suggestLists 筛选后的数据
     */
    void processHandler(UserInfo userInfo, List<String> suggestLists);
}
