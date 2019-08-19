package com.school.book.controller;

import com.school.book.entity.UserInfo;
import com.school.book.service.UserInfoService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    UserInfoService userinfoService;

    @RequestMapping("/login")
    public Object login(@RequestBody UserInfo userinfo){
        return userinfoService.login(userinfo);
    }

    @RequestMapping("/queryAll")
    public Object queryAll(@RequestBody UserInfo userinfo) {
        return userinfoService.queryAll(userinfo);
    }

    @RequestMapping("/add")
    public Object add(@RequestBody UserInfo userinfo) {
        return userinfoService.add(userinfo);
    }

    @RequestMapping("/operateStatus")
    public Object operateStatus(@RequestBody UserInfo userinfo) {
        return userinfoService.operateStatus(userinfo);
    }

    @RequestMapping("/update")
    public Object update(@RequestBody UserInfo userinfo) {
        return userinfoService.update(userinfo);
    }

}