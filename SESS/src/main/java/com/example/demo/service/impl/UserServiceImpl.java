package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guagua on 2019/1/14.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public boolean login(String username,String password){
        return userDao.login(username,password);
    }
}
