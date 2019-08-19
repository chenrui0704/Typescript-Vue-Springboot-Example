package com.school.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.book.util.ModelDao;
import com.school.book.entity.UserInfo;
import com.school.book.dao.UserInfoDao;
import com.school.book.service.UserInfoService;

import java.util.List;
import java.util.Date;

import com.school.book.util.MyResult;
import com.school.book.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userinfoDao;

    @Override
    public Object login(UserInfo userinfo) {
        UserInfo userInfo = userinfoDao.login(userinfo);
        if (null != userInfo) {
            return MyResult.success(userInfo);
        }
        return MyResult.error("无此用户信息，请确定账号或密码是否错误");
    }

    @Override
    public Object queryAll(UserInfo userinfo) {
        PageHelper.startPage(userinfo.getIndex(), 10);
        try {
            List<UserInfo> list = userinfoDao.query(userinfo);
            if (list.size() > 0) {
                return MyResult.success(new PageInfo(list));
            } else {
                return MyResult.error("暂无数据","1001");
            }
        } catch (Exception e) {
            return MyResult.error("请求异常","1002");
        }
    }

    @Override
    public Object add(UserInfo userinfo) {
        userinfo.setInputTime(StringUtil.getCurrentTimeToString());
        userinfoDao.insert(userinfo);
        return "100";
    }

    @Override
    public Object update(UserInfo userinfo) {
        userinfoDao.updateById(userinfo);
        return "100";
    }

    @Override
    public Object operateStatus(UserInfo userinfo) {
        userinfoDao.updateById(userinfo);
        return "100";
    }

}