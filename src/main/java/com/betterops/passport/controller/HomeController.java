package com.betterops.passport.controller;

import com.betterops.passport.domain.User;
import com.betterops.passport.service.UserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    @ResponseBody
    public PageInfo<User> sayHello(@RequestParam("page") int page, @RequestParam("size") int size) {
        logger.info("get all users");
        return userService.getAllUsers(page, size);
    }
}
