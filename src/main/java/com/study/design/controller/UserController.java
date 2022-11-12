package com.study.design.controller;

import com.study.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @description:
 * @author： 灰原二
 * @date: 2022/11/12 21:52
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/suggest")
    public List<String> userSuggest(@RequestParam String username){
        List<String> suggestList = userService.suggestRequirement(username);
        return suggestList;
    }

}
