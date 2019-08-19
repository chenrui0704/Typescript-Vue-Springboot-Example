package com.school.book.service;

import com.school.book.entity.UserInfo;

public interface UserInfoService  {

	Object queryAll(UserInfo userinfo);

	Object add(UserInfo userinfo);

	Object update(UserInfo userinfo);

	Object login(UserInfo userinfo);

	Object operateStatus(UserInfo userinfo);

}