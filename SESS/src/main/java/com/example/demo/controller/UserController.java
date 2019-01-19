package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guagua on 2019/1/14.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public boolean login(String username,String password){
        System.out.println("success");
        return userService.login(username,password);
    }
}
