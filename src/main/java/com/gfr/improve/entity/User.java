package com.gfr.improve.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-01-18 13:48:28
 */
public class User implements Serializable {
    private static final long serialVersionUID = 401096311601757376L;
    /**
     * id字段（主键）
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话号码
     */
    private String telephone;
    /**
     * 头像
     */
    private String userIcon;
    /**
     * 运动总时长
     */
    private Integer sportTime;
    /**
     * 运动累计天数
     */
    private Integer sportDay;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public Integer getSportTime() {
        return sportTime;
    }

    public void setSportTime(Integer sportTime) {
        this.sportTime = sportTime;
    }

    public Integer getSportDay() {
        return sportDay;
    }

    public void setSportDay(Integer sportDay) {
        this.sportDay = sportDay;
    }

}