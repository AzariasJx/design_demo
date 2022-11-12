package com.study.design.handler;

import com.study.design.pojo.UserInfo;

import java.util.List;

/**
 * @description: 通过个人资质的check
 * @author： 灰原二
 * @date: 2022/11/12 22:02
 */
public class PersonalCheckHandler implements SuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        //我们找到了四个可以投放的业务
        suggestLists.add("业务投放1");
        suggestLists.add("业务投放2");
        suggestLists.add("业务投放3");
        suggestLists.add("业务投放4");
    }
}
