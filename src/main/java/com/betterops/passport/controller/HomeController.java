package com.betterops.passport.controller;

import com.betterops.passport.domain.User;
import com.betterops.passport.service.UserService;
import com.betterops.passport.validator.UserValidator;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @RequestMapping(value = "/users")
    @ResponseBody
    public PageInfo<User> sayHello(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "size", required = false, defaultValue = "25") int size) {
        logger.info("get all users");
        return userService.getAllUsers(page, size);
    }

    @RequestMapping(value = "/users", method = {RequestMethod.POST})
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
