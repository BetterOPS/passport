package com.betterops.passport.service;

import com.betterops.passport.domain.User;
import com.betterops.passport.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public PageInfo<User> getAllUsers(int page, int size) {
        return  PageHelper.startPage(page, size).doSelectPageInfo(() -> userMapper.getAllUsers());
    }
}
