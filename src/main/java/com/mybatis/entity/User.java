package com.mybatis.entity;

import java.io.Serializable;

/**
 * 实体类
 */
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private Double account;

    public User() {
    }

    public Integer getUid() {

        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }
}
