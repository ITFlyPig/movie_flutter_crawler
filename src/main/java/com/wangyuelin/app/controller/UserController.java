package com.wangyuelin.app.controller;

import com.wangyuelin.app.bean.User;
import com.wangyuelin.app.crawler.Crawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private Crawler crawler;

//    @Autowired
//    private ITest test;
//
//
    @RequestMapping("/getOneUser")
    @ResponseBody
    public User getOneUser(){

        crawler.addUrl("http://www.zuidazy2.net/?m=vod-type-id-5.html");
        crawler.addUrl("http://www.zuidazy2.net/?m=vod-type-id-5-pg-2.html");
        crawler.addUrl("http://www.zuidazy2.net/?m=vod-type-id-6.html");
        crawler.addUrl("http://www.zuidazy2.net/?m=vod-type-id-6-pg-2.html");
        crawler.addUrl("http://www.zuidazy2.net/?m=vod-type-id-8.html");
        crawler.addUrl("http://www.zuidazy2.net/?m=vod-type-id-8-pg-2.html");

//        crawler.addUrl("http://www.zuidazy2.net/?m=vod-detail-id-60905.html");

        User user = new User();
        user.setName("wang");
        return user;
    }
//
//
//    @RequestMapping("/getAll")
//    @ResponseBody
//    public List<User> getAll(){
//        logger.info("getOneUser");
//        return test.getAll();
//    }

}
