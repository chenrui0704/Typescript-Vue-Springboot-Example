package com.school.book.dao;
import java.util.List;

import com.school.book.util.ModelDao;
import com.school.book.entity.UserInfo;
public  interface UserInfoDao extends ModelDao<UserInfo>  {

    void delete(UserInfo UserInfo);

    void operateStatus(UserInfo UserInfo);

    UserInfo login(UserInfo UserInfo);

}
