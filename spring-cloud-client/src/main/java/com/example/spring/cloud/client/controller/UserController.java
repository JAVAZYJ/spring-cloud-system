package com.example.spring.cloud.client.controller;

import com.example.spring.cloud.client.entity.User;
import com.example.spring.cloud.client.service.UserService;
import com.example.spring.cloud.client.response.DCResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YiJieZhu
 * @since 2019年6月13日 10点17分
 */
@RestController
@Api(value = "/user",tags = {"用户模块管理"})
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userShow")
    @ApiOperation(value = "显示用户信息",notes = "显示用户信息")
    public DCResponse userShow(){
        List<User> userList = userService.list();
        if(CollectionUtils.isEmpty(userList)){
            return DCResponse.error(500,"空指针异常");
        }
        return DCResponse.success(userList);
    }

    @GetMapping("selectUser/{id}")
    @ApiOperation(value = "根据用户ID查询用户信息",notes = "根据用户ID查询用户信息")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long")
    public DCResponse userShow(@PathVariable Long id){
        User user = userService.getById(id);
        if(!ObjectUtils.isEmpty(user)){
            return DCResponse.success(user);
        }
        return DCResponse.error(500,"空指针异常");
    }

    @GetMapping("selectUser/{id}/{username}")
    @ApiOperation(value = "根据用户ID和用户名检查输入用户名是否正确",notes = "根据用户ID和用户名检查输入用户名是否正确")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long"),
            @ApiImplicitParam(name = "username",value = "输入需要验证的用户名",required = true,dataType = "String")
    })
    public DCResponse userShow(@PathVariable Long id,@PathVariable String username){
        User user = userService.getById(id);
        if(!ObjectUtils.isEmpty(user)){
            //判断用户名是否正确
            boolean flag = user.getUsername().equals(username);
            return DCResponse.success(flag);
        }
        return DCResponse.error(500,"空指针异常");
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "更新用户信息",notes = "更新用户信息")
    public DCResponse userShow(@RequestBody User user){
        boolean id = userService. updateById(user);
        return DCResponse.success(id);
    }
}
