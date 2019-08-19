package com.school.book.entity;

import java.util.Date;

public class UserInfo {

    private Integer id;
    private String name;
    private String loginName;
    private String password;
    private Integer status;
    private Integer inputId;
    private String inputTime;
    private Integer role;
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public void setLoginName(String value) {
        this.loginName = value;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setStatus(Integer value) {
        this.status = value;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setInputId(Integer value) {
        this.inputId = value;
    }

    public Integer getInputId() {
        return this.inputId;
    }

    public void setInputTime(String value) {
        this.inputTime = value;
    }

    public String getInputTime() {
        return this.inputTime;
    }


    public UserInfo() {
    }


}