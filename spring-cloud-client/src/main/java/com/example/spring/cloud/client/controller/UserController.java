package com.example.spring.cloud.client.controller;

import com.example.spring.cloud.client.entity.User;
import com.example.spring.cloud.client.service.UserService;
import com.example.spring.cloud.client.response.DCResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YiJieZhu
 * @since 2019年6月13日 10点17分
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userShow")
    public DCResponse userShow(){
        List<User> userList = userService.list();
        if(!CollectionUtils.isEmpty(userList)){
            return DCResponse.success(userList);
        }
        return DCResponse.error(500,"空指针异常");
    }

}
