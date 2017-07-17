package com.betterops.passport.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lqs on 2017/6/15.
 */

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(HttpServletRequest request) {
        logger.info("test");
        return "Hello World!";
    }
}
