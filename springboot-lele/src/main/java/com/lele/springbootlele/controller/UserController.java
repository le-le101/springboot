package com.lele.springbootlele.controller;

import com.lele.springbootlele.pojo.ResponseMessage;
import com.lele.springbootlele.pojo.User;
import com.lele.springbootlele.pojo.dto.UserDto;
import com.lele.springbootlele.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController         //接口放过返回对象并转化为json文本
@RequestMapping("/user")        // localhost:8088/user/**
public class UserController {

    @Autowired
    private IUserService userService;


    // Rest风格的注解
    // 新增
    // 客户端请求的参数不一定是我们当前类所需要的参数。功能简单完全可以，但如果要求规范要加一个对应的Dto类
    // 传进来的是一个json文本，@RequestBody自动将其转化为对应的类
    // 在需要添加参数校验的地方加上@Validated注解
    @PostMapping        // URL ： localhost:8088/user    method:post
    public ResponseMessage add(@Validated @RequestBody UserDto user){
        User userNew = userService.add(user);
        return ResponseMessage.success(userNew);
    }

    // 查询
    @GetMapping("/{userId}")
    public ResponseMessage get(@PathVariable Integer userId){
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }

    // 修改
    @PutMapping
    public ResponseMessage edit(@Validated @RequestBody UserDto user){
        User userNew = userService.edit(user);
        return ResponseMessage.success(userNew);
    }

    // 删除
    @DeleteMapping("/{userId}")
    public ResponseMessage delete(@PathVariable Integer userId){
        userService.delete(userId);
        return ResponseMessage.success();
    }
}
