package com.study.design.handler;

import com.study.design.pojo.UserInfo;

import java.util.List;

/**
 * @description: 最近购买check
 * @author： 灰原二
 * @date: 2022/11/12 22:05
 */
public class RecentCheckHandler implements SuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
         List<String> buyProducts = userInfo.getBuyProducts();
        suggestLists.remove("业务投放2");
    }
}
