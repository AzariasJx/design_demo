package com.study.design.handler;

import com.study.design.pojo.UserInfo;

import java.util.List;

/**
 * @description: 根据城市筛选
 * @author： 灰原二
 * @date: 2022/11/12 22:01
 */
public class CityCheckHandler implements SuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        userInfo.getCity();
        suggestLists.remove("业务投放4");
    }
}
