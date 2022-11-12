package com.study.design.service;

import com.study.design.handler.SuggestRequirementHandlerProcesser;
import com.study.design.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 21:52
 */
@Service
public class UserService {

    @Autowired
    private SuggestRequirementHandlerProcesser processer;

    /**
     * 根据用户信息，执行投放
     * @param username
     * @return
     */
    public List<String> suggestRequirement(String username){
        UserInfo userInfo = getUserInfo(username);
        List<String> result = new ArrayList<>();
        processer.process(userInfo,result);
        return result;

    }

    private UserInfo getUserInfo(String username) {
        UserInfo userInfo = new UserInfo();
        if(username.equals("新用户")){
            userInfo.setNewUser(true);
        }
        return userInfo;
    }
}
