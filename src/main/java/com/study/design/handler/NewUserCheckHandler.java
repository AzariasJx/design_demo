package com.study.design.handler;

import com.study.design.pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 22:06
 */
public class NewUserCheckHandler implements SuggestRequirementHandler{
    @Override
    public void processHandler(UserInfo userInfo, List<String> suggestLists) {
        if(userInfo.isNewUser()){
            //特定的新用户奖励
            suggestLists.add("新用户奖励");
        }
    }
}
