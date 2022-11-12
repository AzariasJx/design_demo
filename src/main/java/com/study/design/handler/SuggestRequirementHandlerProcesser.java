package com.study.design.handler;

import com.study.design.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 22:08
 */
@Component
public class SuggestRequirementHandlerProcesser {

    @Value("#{'${suggest.requirement.handler}'.split(',')}")
    private List<String> handlerClassName;

    public void process(UserInfo userInfo, List<String> suggestLists){
        //使用配置中心实时配置
       try{
           for (String name : handlerClassName) {
               SuggestRequirementHandler handler = (SuggestRequirementHandler) Class.forName(name).newInstance();
               handler.processHandler(userInfo,suggestLists);
           }
       }catch (Exception e){

       }
    }
}
